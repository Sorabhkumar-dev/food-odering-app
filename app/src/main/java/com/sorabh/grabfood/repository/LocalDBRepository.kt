package com.sorabh.grabfood.repository

import android.content.Context
import com.sorabh.grabfood.Database.RestaurantDatabase
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.util.QNAData

class LocalDBRepository(context: Context) {
    private val dbAPI = RestaurantDatabase.getRestaurantDatabaseInstance(context).getLocalDAO()

    /*--------------------- Restaurant Home  ---------------------*/
    fun insertRestaurant(restaurant: com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX) {
        dbAPI.insertRestaurant(restaurant)
    }


    fun deleteRestaurant(restaurant: com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX) {
        dbAPI.deleteRestaurant(restaurant)
    }

    fun getRestaurantList(): List<com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX>? {
        return dbAPI.getRestaurantList()
    }

    fun getRestaurant(id: String): com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX? {
        return dbAPI.getRestaurant(id)
    }

    /*--------------------- Restaurant menu ---------------------*/
    fun insertMenu(menu: DataX) {
        dbAPI.insertMenu(menu)
    }

    fun deleteAllMenu(restaurant_Id: String) {
    dbAPI.deleteAllMenu(restaurant_Id)
    }

    fun deleteMenu(menu: DataX) {
        dbAPI.deleteMenu(menu)
    }

    fun getMenuList(): List<DataX>? {
        return dbAPI.getMenuList()
    }

    fun getMenuItem(id: String): DataX? {
        return dbAPI.getMenuItem(id)
    }

    /*--------------------- Restaurant QNA ---------------------*/

    fun insertQNAData(qnaData: QNAData) {
        dbAPI.insertQNAData(qnaData)
    }

    fun deleteQNAData(qnaData: QNAData) {
        dbAPI.deleteQNAData(qnaData)
    }

    fun getQNAList(): List<QNAData>? {
        return dbAPI.getQNAList()
    }
}