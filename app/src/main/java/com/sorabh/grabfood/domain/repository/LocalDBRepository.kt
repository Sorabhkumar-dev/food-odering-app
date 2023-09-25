package com.sorabh.grabfood.domain.repository

import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData
import javax.inject.Inject

class LocalDBRepository @Inject constructor(private val localDAO: LocalDAO) {

    // Restaurant Home
  suspend  fun insertRestaurant(restaurant: Dish) {
        localDAO.insertRestaurant(restaurant)
    }


    suspend fun deleteRestaurant(restaurant: Dish) {
        localDAO.deleteRestaurant(restaurant)
    }

   fun getRestaurantList() = localDAO.getRestaurantList()

   suspend fun getRestaurant(id: String): Int {
        return localDAO.getRestaurant(id)
    }

    suspend fun insertMenu(menu: Menu) {
        localDAO.insertMenu(menu)
    }


   suspend fun deleteMenu(menu: Menu) {
        localDAO.deleteMenu(menu)
    }

   fun getMenuList() = localDAO.getMenuList()

   suspend fun getMenuItem(id: String): Int {
        return localDAO.getMenuItem(id)
    }

    // Restaurant QNA

    fun upsertQNAs(questions:List<QNAData>){
        localDAO.upsertQNAs(questions)
    }

    fun getQNAList(): List<QNAData> {
        return localDAO.getQNAList()
    }
}