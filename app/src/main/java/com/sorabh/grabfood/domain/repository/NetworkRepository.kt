package com.sorabh.grabfood.domain.repository

import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.Data
import com.sorabh.grabfood.api_response_classes.login_respones.LoginRespones
import com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.network_api.GetFoodInterface
import com.sorabh.grabfood.domain.network_api.NetworkInterface

class NetworkRepository {

    private val getApi = GetFoodInterface.getInstance().create(NetworkInterface::class.java)

    // Login Activity
    suspend fun getLoginDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): LoginRespones? {
        return getApi.getLoginDetails(header, params).body()
    }

    // SignUp Activity

    suspend fun getSignUpDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): SignUpResponse? {
        return getApi.getSignUpDetails(header, params).body()
    }

    // OTP Activity

    suspend fun getForgotResponse(header: HashMap<String, String>, params: JsonObject): Data? {
        return getApi.getForgotResponse(header, params).body()?.data
    }

    // OTP Activity

    suspend fun getOTPResponse(
        header: HashMap<String, String>,
        params: JsonObject
    ): com.sorabh.grabfood.api_response_classes.otp_response.Data? {
        return getApi.getOTPResponse(header, params).body()?.data
    }

    // Home Fragment

    suspend fun getRestaurantsList(header: HashMap<String, String>): List<DataX>? {
        return getApi.getRestaurantsList(header).body()?.data?.data
    }
    // Restaurant Menu Fragment

    suspend fun getMenuList(
        header: HashMap<String, String>,
        restaurant_id: String
    ): List<com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX>? {

        return getApi.getRestaurantMenu(header, restaurant_id).body()?.data?.data

    }

    // Cart Adapter
   suspend fun placeOder(header: HashMap<String, String>, params: JsonObject): Boolean? {
      val response =  getApi.placeOder(header, params).body()?.data
        return response?.success
    }

    // Oder Fragment
    suspend fun getOderHistory(
        header: HashMap<String, String>,
        user_id: String?
    ): com.sorabh.grabfood.api_response_classes.oder_history_response.Data? {

        return getApi.getOderHistory(header, user_id).body()?.data
    }
}