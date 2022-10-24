package com.sorabh.grabfood.api_response_classes.restaurant_menu_response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Menu")
data class  DataX(

    val cost_for_one: String,
    val id: String,
    @PrimaryKey
    val name: String,
    val restaurant_id: String
)