package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
    private suspend fun getDishes(){
        localDBRepository.getRestaurantList().collect{
            _getDishesFlow.emit(it)
        }
    }

    suspend fun insertRestaurant(dish:Dish):Boolean{
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.insertRestaurant(dish)
            isRestaurantStored(dish.id)
        }
        return result.await()
    }

    suspend fun deleteRestaurant(dish:Dish):Boolean{
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.deleteRestaurant(dish)
            isRestaurantStored(dish.id)
        }
        return !result.await()
    }

    suspend fun isRestaurantStored(id:String):Boolean{
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.getRestaurant(id)
        }
        return result.await() > 0
    }
}