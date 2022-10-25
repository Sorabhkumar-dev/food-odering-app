package com.sorabh.grabfood.domain.model.restaurant_menu_response

data class MenuItem(
    val `data`: List<Menu>,
    val success: Boolean
)