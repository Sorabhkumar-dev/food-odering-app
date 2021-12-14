package com.sorabh.grabfood.api_response_classes.oder_history_response

data class DataX(
    val food_items: List<FoodItem>,
    val order_id: String,
    val order_placed_at: String,
    val restaurant_name: String,
    val total_cost: String
)