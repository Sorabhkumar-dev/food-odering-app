package com.sorabh.grabfood.domain.repository

import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.network_api.Result

interface NetworkRepository {
    suspend fun getLoginDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<LoginResponse>

    suspend fun getSignUpDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<SignUpResponse>

    suspend fun getForgotResponse(header: HashMap<String, String>, params: JsonObject): Result<ForgotResponse>

    suspend fun getOTPResponse(
        header: HashMap<String, String>,
        params: JsonObject
    ): com.sorabh.grabfood.api_response_classes.otp_response.Data?

    suspend fun getRestaurantsList(header: HashMap<String, String>): Result<Restaurant>

    suspend fun getMenuList(
        header: HashMap<String, String>,
        restaurant_id: String
    ): Result<RestaurantMenu>


    suspend fun placeOder(header: HashMap<String, String>, params: JsonObject): Result<OderConfirmation>

    suspend fun getOderHistory(
        header: HashMap<String, String>,
        user_id: String?
    ): Result<OderHistory>
}