package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getOderConfirmationUseCase: GetOderConfirmationUseCase,
    private val localDBRepository: LocalDBRepository,
    preferenceData: PreferenceData
) : ViewModel() {
    private val _oderConfirmationFlow: MutableStateFlow<Result<OderConfirmation>> =
        MutableStateFlow(
            Result.Loading()
        )
    val oderConfirmationFlow: StateFlow<Result<OderConfirmation>> = _oderConfirmationFlow

    private val _menuFlow: MutableStateFlow<List<Menu>> = MutableStateFlow(emptyList())
    val menuFlow: StateFlow<List<Menu>> = _menuFlow

    private val userIdFlow = preferenceData.readUserIdFlow

    init {
        viewModelScope.launch { getMenu() }
    }

    fun placeOrder(menu: Menu) {
        viewModelScope.launch {
            val userId: String = userIdFlow.first()
            val jsonObject = JsonObject()
            jsonObject.addProperty(Keys.USER_ID, userId)
            jsonObject.addProperty(Keys.RESTAURANT_ID, menu.restaurant_id)
            jsonObject.addProperty(Keys.TOTAL_COST, menu.cost_for_one)

            val food = JsonObject()
            food.addProperty(Keys.FOOD_ITEM_ID, menu.id)

            val foodItem = JsonArray()
            foodItem.add(food)

            jsonObject.add(Keys.FOOD, foodItem)

            //header to send
            val header = HashMap<String, String>()
            header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
            header[Keys.TOKEN] = Constants.MAIN_TOKEN
            placeOder(OderPostModel(header, jsonObject)) {
                deleteMenu(menu)
            }
        }
    }

    suspend fun placeOder(oderPostModel: OderPostModel, onOderPlaced: suspend () -> Unit) {
        getOderConfirmationUseCase(oderPostModel).collect {
            _oderConfirmationFlow.emit(it)
            if (it is Result.Success)
                onOderPlaced()
        }
    }

    private suspend fun deleteMenu(menu: Menu): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.deleteMenu(menu)
            isMenuSaved(menu.id)
        }
        return !result.await()
    }

    private suspend fun isMenuSaved(id: String): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.getMenuItem(id)
        }
        return true
    }

    private suspend fun getMenu() {
        CoroutineScope(Dispatchers.IO).launch {
            localDBRepository.getMenuList().collect {
                _menuFlow.emit(it)
            }
        }
    }

}