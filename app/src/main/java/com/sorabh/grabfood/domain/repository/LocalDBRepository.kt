package com.sorabh.grabfood.domain.repository

import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData
import javax.inject.Inject

class LocalDBRepository @Inject constructor(private val localDAO: LocalDAO) {

    // Restaurant Home
    fun insertRestaurant(restaurant: Dish) {
        localDAO.insertRestaurant(restaurant)
    }


    fun deleteRestaurant(restaurant: Dish) {
        localDAO.deleteRestaurant(restaurant)
    }

    fun getRestaurantList(): List<Dish>? {
        return localDAO.getRestaurantList()
    }

    fun getRestaurant(id: String): Dish? {
        return localDAO.getRestaurant(id)
    }

    // Restaurant menu
    fun insertMenu(menu: Menu) {
        localDAO.insertMenu(menu)
    }


    fun deleteMenu(menu: Menu) {
        localDAO.deleteMenu(menu)
    }

    fun getMenuList(): List<Menu>? {
        return localDAO.getMenuList()
    }

    fun getMenuItem(id: String): Menu? {
        return localDAO.getMenuItem(id)
    }

    // Restaurant QNA

    fun insertQNAData(qnaData: QNAData) {
        localDAO.insertQNAData(qnaData)
    }

    fun getQNAList(): List<QNAData>? {
        return localDAO.getQNAList()
    }
}