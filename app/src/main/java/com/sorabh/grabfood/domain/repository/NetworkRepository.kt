package com.sorabh.grabfood.domain.repository

import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.Data
import com.sorabh.grabfood.domain.model.reataurants_home_response.DataX
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.network_api.Result

interface NetworkRepository {
    suspend fun getLoginDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<LoginResponse>

    suspend fun getSignUpDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): SignUpResponse?

    suspend fun getForgotResponse(header: HashMap<String, String>, params: JsonObject): Data?

    suspend fun getOTPResponse(
        header: HashMap<String, String>,
        params: JsonObject
    ): com.sorabh.grabfood.api_response_classes.otp_response.Data?

    suspend fun getRestaurantsList(header: HashMap<String, String>): List<DataX>?

    suspend fun getMenuList(
        header: HashMap<String, String>,
        restaurant_id: String
    ): List<com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX>?


    suspend fun placeOder(header: HashMap<String, String>, params: JsonObject): Boolean?

    suspend fun getOderHistory(
        header: HashMap<String, String>,
        user_id: String?
    ): com.sorabh.grabfood.api_response_classes.oder_history_response.Data?
}