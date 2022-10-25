package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantMenuViewModel @Inject constructor(private val getRestaurantMenuUseCase: GetRestaurantMenuUseCase) :
    ViewModel() {
    private val _restaurantMenuFlow: MutableStateFlow<Result<RestaurantMenu>> = MutableStateFlow(
        Result.Loading())
    val restaurantMenuFlow:StateFlow<Result<RestaurantMenu>> = _restaurantMenuFlow
    fun getRestaurantMenu(restaurantMenuPostModel: RestaurantMenuPostModel){
        viewModelScope.launch {
            getRestaurantMenuUseCase(restaurantMenuPostModel).collect{
                when(it){
                    is Result.Error -> _restaurantMenuFlow.emit(it)
                    is Result.Loading -> _restaurantMenuFlow.emit(it)
                    is Result.Success -> _restaurantMenuFlow.emit(it)
                }
            }
        }
    }

}