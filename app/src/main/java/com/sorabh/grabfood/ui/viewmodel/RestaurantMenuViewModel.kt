package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(
    private val getRestaurantMenuUseCase: GetRestaurantMenuUseCase,
    private val localDBRepository:LocalDBRepository
) : ViewModel() {
    private val _restaurantMenuFlow: MutableStateFlow<Result<RestaurantMenu>> =
        MutableStateFlow(Result.Loading())
    val restaurantMenuFlow = _restaurantMenuFlow.asStateFlow()


    fun getRestaurantMenus(restaurantId: String) {
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN
        getRestaurantMenus(RestaurantMenuPostModel(header, restaurantId))
    }

    private fun getRestaurantMenus(restaurantMenuPostModel: RestaurantMenuPostModel) {
        viewModelScope.launch {
            getRestaurantMenuUseCase(restaurantMenuPostModel).collect {
                _restaurantMenuFlow.emit(it)
            }
        }
    }

    fun onMenuClicked(menu: Menu) {
        viewModelScope.launch {
                if (isMenuSaved(menu.id).first() > 0) localDBRepository.deleteMenu(menu) else localDBRepository.insertMenu(menu)

        }
    }

    fun isMenuSaved(id: String): Flow<Int> = localDBRepository.getMenuItem(id)


}