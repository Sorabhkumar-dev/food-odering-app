package com.sorabh.grabfood.domain.repository

import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData
import kotlinx.coroutines.flow.Flow

interface LocalDBRepository {

    // Restaurant Home
    suspend fun insertRestaurant(dish: Dish)


    suspend fun deleteRestaurant(dish: Dish)

    fun getRestaurantList(): Flow<List<Dish>>

    fun getRestaurant(id: String): Flow<Int>


    suspend fun insertMenu(menu: Menu)


    suspend fun deleteMenu(menu: Menu)

    fun getMenuList(): Flow<List<Menu>>

    fun getMenuItem(id: String): Flow<Int>

    // Restaurant QNA

    fun upsertQNAs(questions: List<QNAData>)

    fun getQNAList(): List<QNAData>
}