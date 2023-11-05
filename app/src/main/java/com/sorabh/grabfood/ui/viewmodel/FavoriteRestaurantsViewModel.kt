package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteRestaurantsViewModel @Inject constructor(private val localDBRepository: LocalDBRepository) :
    ViewModel() {

    private val _getDishesFlow: MutableStateFlow<List<Dish>> = MutableStateFlow(emptyList())
    val getDishesFlow: StateFlow<List<Dish>> = _getDishesFlow

    init {
        viewModelScope.launch {
            getDishes()
        }
    }

    private suspend fun getDishes() {
        localDBRepository.getRestaurantList().collect {
            _getDishesFlow.emit(it)
        }
    }

    fun onFavoriteIconBtnClick(dish: Dish) {
        viewModelScope.launch {
            if (localDBRepository.getRestaurant(dish.id).first() > 0)
                localDBRepository.deleteRestaurant(dish)
            else
                localDBRepository.insertRestaurant(dish)
        }
    }

    fun isDishStored(id: String) =  localDBRepository.getRestaurant(id)

}