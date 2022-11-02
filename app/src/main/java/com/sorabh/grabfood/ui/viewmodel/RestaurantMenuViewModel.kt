package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(
    private val getRestaurantMenuUseCase: GetRestaurantMenuUseCase,
    private val localDBRepository: LocalDBRepository
) : ViewModel() {
    private val _restaurantMenuFlow: MutableStateFlow<Result<RestaurantMenu>> = MutableStateFlow(
        Result.Loading()
    )
    val restaurantMenuFlow: StateFlow<Result<RestaurantMenu>> = _restaurantMenuFlow

//    private val _menuFlow: MutableStateFlow<List<Menu>> = MutableStateFlow(emptyList())
//    val menuFlow: StateFlow<List<Menu>> = _menuFlow
//
//    init {
//        viewModelScope.launch {
//            getMenu()
//        }
//    }

    fun getRestaurantMenu(restaurantMenuPostModel: RestaurantMenuPostModel) {
        viewModelScope.launch {
            getRestaurantMenuUseCase(restaurantMenuPostModel).collect {
                when (it) {
                    is Result.Error -> _restaurantMenuFlow.emit(it)
                    is Result.Loading -> _restaurantMenuFlow.emit(it)
                    is Result.Success -> _restaurantMenuFlow.emit(it)
                }
            }
        }
    }

    suspend fun insertMenu(menu: Menu): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.insertMenu(menu)
            isMenuSaved(menu.id)
        }
        return result.await()
    }

    suspend fun deleteMenu(menu: Menu): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.deleteMenu(menu)
            isMenuSaved(menu.id)
        }
        return !result.await()
    }

    suspend fun isMenuSaved(id: String): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.getMenuItem(id)
        }
        return result.await() > 0
    }

//   private suspend fun getMenu() {
//        CoroutineScope(Dispatchers.IO).launch {
//            localDBRepository.getMenuList().collect {
//                _menuFlow.emit(it)
//            }
//        }
//    }
}