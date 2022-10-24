package com.sorabh.grabfood.domain.model.login_respones

data class User(
    val address: String,
    val email: String,
    val mobile_number: String,
    val name: String,
    val user_id: String
)