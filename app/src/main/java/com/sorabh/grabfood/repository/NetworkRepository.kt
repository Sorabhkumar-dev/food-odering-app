package com.sorabh.grabfood.repository

import android.util.Log
import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.Data
import com.sorabh.grabfood.api_response_classes.login_respones.LoginRespones
import com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.network_api.GetFoodInterface
import com.sorabh.grabfood.network_api.NetworkInterface

class NetworkRepository {

    private val getApi = GetFoodInterface.getInstance().create(NetworkInterface::class.java)

    /* ________________________________ Login Activity __________________________________________*/
    suspend fun getLoginDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): LoginRespones? {
        return getApi.getLoginDetails(header, params).body()
    }

    /* ________________________________ SignUp Activity __________________________________________*/

    suspend fun getSignUpDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): SignUpResponse? {
        return getApi.getSignUpDetails(header, params).body()
    }

    /* ________________________________ OTP Activity __________________________________________*/

    suspend fun getForgotResponse(header: HashMap<String, String>, params: JsonObject): Data? {
        return getApi.getForgotResponse(header, params).body()?.data
    }

    /* ________________________________ OTP Activity __________________________________________*/

    suspend fun getOTPResponse(
        header: HashMap<String, String>,
        params: JsonObject
    ): com.sorabh.grabfood.api_response_classes.otp_response.Data? {
        return getApi.getOTPResponse(header, params).body()?.data
    }

    /* ________________________________ Home Fragment __________________________________________*/

    suspend fun getRestaurantsList(header: HashMap<String, String>): List<DataX>? {
        return getApi.getRestaurantsList(header).body()?.data?.data
    }
    /* ________________________________ Restaurant Menu Fragment __________________________________________*/

    suspend fun getMenuList(
        header: HashMap<String, String>,
        restaurant_id: String
    ): List<com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX>? {

        return getApi.getRestaurantMenu(header, restaurant_id).body()?.data?.data

    }

    /* ________________________________ Cart Adapter __________________________________________*/
   suspend fun placeOder(header: HashMap<String, String>, params: JsonObject): Boolean? {
      val response =  getApi.placeOder(header, params).body()?.data
        Log.d("excc",response.toString())
        return response?.success
    }

    /* ________________________________ Oder Fragment __________________________________________*/
    suspend fun getOderHistory(
        header: HashMap<String, String>,
        user_id: String?
    ): com.sorabh.grabfood.api_response_classes.oder_history_response.Data? {

        return getApi.getOderHistory(header, user_id).body()?.data
    }
}