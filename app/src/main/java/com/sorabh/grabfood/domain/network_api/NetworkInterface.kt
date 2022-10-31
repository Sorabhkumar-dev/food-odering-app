package com.sorabh.grabfood.domain.network_api

import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import retrofit2.Response
import retrofit2.http.*

interface NetworkInterface {

    @POST("login/fetch_result")
    suspend fun getLoginDetails(
        @HeaderMap header: HashMap<String, String>,
        @Body params: JsonObject
    ): Response<LoginResponse>

    @POST("register/fetch_result")
    suspend fun getSignUpDetails(
        @HeaderMap header: HashMap<String, String>,
        @Body params: JsonObject
    ): Response<SignUpResponse>

    @POST("forgot_password/fetch_result")
    suspend fun getForgotResponse(
        @HeaderMap header: HashMap<String, String>,
        @Body params: JsonObject
    ): Response<ForgotResponse>


    @POST("reset_password/fetch_result")
    suspend fun getOTPResponse(
        @HeaderMap header: HashMap<String, String>,
        @Body params: JsonObject
    ): Response<OTPResponse>

    @GET("restaurants/fetch_result/")
    suspend fun getRestaurantsList(
        @HeaderMap header: HashMap<String, String>,
    ): Response<Restaurant>

    @GET("restaurants/fetch_result/{id}")
    suspend fun getRestaurantMenu(
        @HeaderMap header: HashMap<String, String>,
        @Path("id") restaurant_id: String
    ): Response<RestaurantMenu>

    @POST("place_order/fetch_result/")
   suspend fun placeOder(
        @HeaderMap header: HashMap<String, String>,
        @Body params: JsonObject
    ): Response<OderConfirmation>

    @GET("orders/fetch_result/{user_id}")
    suspend fun getOderHistory(
        @HeaderMap header: HashMap<String, String>,
        @Path("user_id") user_id: String?
    ): Response<OderHistory>

}