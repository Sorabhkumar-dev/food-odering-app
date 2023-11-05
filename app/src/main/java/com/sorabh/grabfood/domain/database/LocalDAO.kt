package com.sorabh.grabfood.domain.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalDAO {

    @Insert
    suspend fun insertRestaurant(dish: Dish)

    @Delete
    suspend fun deleteRestaurant(dish: Dish)

    @Query("Select * from Restaurant")
    fun getRestaurantList(): Flow<List<Dish>>

    @Query("select Count(id) from Restaurant where id = :id")
    suspend fun getRestaurant(id: String): Int

    @Insert
    suspend fun insertMenu(menu: Menu)

    @Query("select Count(id) from menu where id = :id")
    fun getMenuItem(id: String): Flow<Int>

    @Delete
    suspend fun deleteMenu(menu: Menu)

    @Query("delete from menu where restaurant_id =:restaurantId")
    suspend fun deleteAllMenu(restaurantId: String)

    @Query("Select * from menu")
    fun getMenuList(): Flow<List<Menu>>

    @Upsert
    fun upsertQNAs(questions: List<QNAData>)

    @Delete
    fun deleteQNAData(qnaData: QNAData)

    @Query("select * from QNA_TABLE")
    fun getQNAList(): List<QNAData>
}