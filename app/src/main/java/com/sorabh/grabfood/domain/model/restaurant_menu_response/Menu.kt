package com.sorabh.grabfood.domain.model.restaurant_menu_response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Menu")
data class  Menu(

    val cost_for_one: String,
    val id: String,
    @PrimaryKey
    val name: String,
    val restaurant_id: String
)