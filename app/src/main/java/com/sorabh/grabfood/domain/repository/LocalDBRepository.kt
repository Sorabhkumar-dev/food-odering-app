package com.sorabh.grabfood.domain.repository

import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.domain.database.LocalDAO
import com.sorabh.grabfood.util.QNAData
import javax.inject.Inject

class LocalDBRepository @Inject constructor(private val localDAO: LocalDAO) {

    // Restaurant Home
    fun insertRestaurant(restaurant: com.sorabh.grabfood.domain.model.reataurants_home_response.DataX) {
        localDAO.insertRestaurant(restaurant)
    }


    fun deleteRestaurant(restaurant: com.sorabh.grabfood.domain.model.reataurants_home_response.DataX) {
        localDAO.deleteRestaurant(restaurant)
    }

    fun getRestaurantList(): List<com.sorabh.grabfood.domain.model.reataurants_home_response.DataX>? {
        return localDAO.getRestaurantList()
    }

    fun getRestaurant(id: String): com.sorabh.grabfood.domain.model.reataurants_home_response.DataX? {
        return localDAO.getRestaurant(id)
    }

    // Restaurant menu
    fun insertMenu(menu: DataX) {
        localDAO.insertMenu(menu)
    }


    fun deleteMenu(menu: DataX) {
        localDAO.deleteMenu(menu)
    }

    fun getMenuList(): List<DataX>? {
        return localDAO.getMenuList()
    }

    fun getMenuItem(id: String): DataX? {
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