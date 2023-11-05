package com.sorabh.grabfood.ui.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material.icons.outlined.LocalDrink
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.local_model.tab.HomeTab
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getRestaurantUseCase: GetRestaurantUseCase,
    private val localDBRepository:LocalDBRepository
) : ViewModel() {
    private val _restaurantFlow: MutableStateFlow<Result<Restaurant>> =
        MutableStateFlow(Result.Loading())
    val restaurantFlow = _restaurantFlow.asStateFlow()

    val homeTabs = mutableListOf(
        HomeTab(
            tabImage = Icons.Outlined.Fastfood,
            tabTitle = R.string.foods,
            description = "food icon"
        ),
        HomeTab(
            tabImage = Icons.Outlined.LocalDrink,
            tabTitle = R.string.drinks,
            description = "drinks icon"
        )
    )

    val selectedTab = MutableStateFlow(homeTabs[0])


    init {
        getRestaurants()
    }

    fun onTabChanged(tab: HomeTab){
        selectedTab.value = tab
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

    fun onFavoriteIconBtnClick(dish: Dish) {
        viewModelScope.launch {
            if (localDBRepository.getRestaurant(dish.id).first() > 0)
                localDBRepository.deleteRestaurant(dish)
            else
                localDBRepository.insertRestaurant(dish)
        }
    }
    fun isDishStored(id: String) = localDBRepository.getRestaurant(id)

}