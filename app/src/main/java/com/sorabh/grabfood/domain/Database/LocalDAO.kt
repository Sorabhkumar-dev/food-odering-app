package com.sorabh.grabfood.Database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.util.QNAData

@Dao
interface LocalDAO {

    /*--------------------- Favorite Restaurant ---------------------*/
    @Insert
    fun insertRestaurant(restaurant:com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX)

    @Delete
    fun deleteRestaurant(restaurant:com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX)

    @Query("Select * from Restaurant")
    fun getRestaurantList(): List<com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX>?

    @Query("select * from Restaurant where id = :id")
    fun getRestaurant(id:String):com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX?

    /*--------------------- Restaurant Menu ---------------------*/
    @Insert
    fun insertMenu(menu: DataX)

    @Delete
    fun deleteMenu(menu: DataX)

    @Query("delete from menu where restaurant_id =:restaurant_id")
    fun deleteAllMenu(restaurant_id:String)

    @Query("Select * from menu")
    fun getMenuList(): List<DataX>?

    @Query("select * from menu where id = :id")
    fun getMenuItem(id:String):DataX?

    /*--------------------- Restaurant QNA ---------------------*/
    @Insert
    fun insertQNAData(qnaData: QNAData)

    @Delete
    fun deleteQNAData(qnaData: QNAData)

    @Query("select * from QNA_TABLE")
    fun getQNAList():List<QNAData>?
}