package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val localDBRepository: LocalDBRepository
) : ViewModel() {
    private val _restaurantFlow: MutableStateFlow<Result<Restaurant>> =
        MutableStateFlow(Result.Loading())
    val restaurantFlow: StateFlow<Result<Restaurant>> = _restaurantFlow

    init {
        getRestaurants()
    }

    fun getRestaurants() {
        viewModelScope.launch {
            val header = HashMap<String, String>()
            header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
            header[Keys.TOKEN] = Constants.MAIN_TOKEN
            getRestaurantUseCase(header).collect {
                when (it) {
                    is Result.Error -> _restaurantFlow.emit(it)
                    is Result.Loading -> _restaurantFlow.emit(it)
                    is Result.Success -> _restaurantFlow.emit(it)
                }
            }
        }
    }

    suspend fun insertRestaurant(dish: Dish): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.insertRestaurant(dish)
            isRestaurantStored(dish.id)
        }
        return result.await()
    }

    suspend fun deleteRestaurant(dish: Dish): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.deleteRestaurant(dish)
            isRestaurantStored(dish.id)
        }
        return !result.await()
    }

    suspend fun isRestaurantStored(id: String): Boolean {
        val result = CoroutineScope(Dispatchers.IO).async {
            localDBRepository.getRestaurant(id)
        }
        return result.await() > 0
    }
}