package com.sorabh.grabfood.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.util.QNAData

@Database(entities = [Menu::class, QNAData::class, com.sorabh.grabfood.domain.model.reataurants_home_response.Dish::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {
   abstract fun getLocalDAO(): LocalDAO
   
   companion object{
        var INSTANCE : RestaurantDatabase?= null
       private const val RESTAURANT_DB_NAME="RESTAURANT_DATA"
       @Synchronized
       fun getRestaurantDatabaseInstance(context: Context): RestaurantDatabase {
           if (INSTANCE ==null){
               INSTANCE = Room.databaseBuilder(context, RestaurantDatabase::class.java,
                   RESTAURANT_DB_NAME
               ).build()
           }
           return INSTANCE!!
       }
   }
}