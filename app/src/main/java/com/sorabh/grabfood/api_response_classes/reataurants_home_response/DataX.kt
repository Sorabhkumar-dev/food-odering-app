package com.sorabh.grabfood.api_response_classes.reataurants_home_response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Restaurant")
data class DataX(
    val cost_for_one: String,
    @PrimaryKey
    val id: String,
    val image_url: String,
    val name: String,
    val rating: String
)