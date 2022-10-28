package com.sorabh.grabfood.domain.model.oder_history_response

import com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem

data class Bill(
    val food_items: List<FoodItem>,
    val order_id: String,
    val order_placed_at: String,
    val restaurant_name: String,
    val total_cost: String
)