package com.sorabh.grabfood.domain.repository

import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu
import com.sorabh.grabfood.domain.network_api.NetworkInterface
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.util.Constants
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val networkInterface: NetworkInterface) :NetworkRepository{

    // Login Activity
   override suspend fun getLoginDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<LoginResponse> {
        val response = networkInterface.getLoginDetails(header, params)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(),response.code(),response.message())
            else
                Result.Error(response.code(),response.message())
        }catch (e:Exception){
            Result.Error(response.code(),e.message ?: Constants.NETWORK_ERROR)
        }
    }

    // SignUp Activity

    override suspend fun getSignUpDetails(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<SignUpResponse> {
        val response = networkInterface.getSignUpDetails(header, params)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(), response.code(), response.message())
            else
                Result.Error(response.code(), response.message())
        } catch (e: Exception) {
            Result.Error(response.code(), response.message())
        }
    }

    // OTP Activity

    override suspend fun getForgotResponse(header: HashMap<String, String>, params: JsonObject): Result<ForgotResponse> {
        val response =  networkInterface.getForgotResponse(header, params)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(),response.code(),response.message())
            else
                Result.Error(response.code(),response.message())
        }catch (e:Exception){
            Result.Error(response.code(),e.message ?: Constants.NETWORK_ERROR)
        }
    }

    // OTP Activity

    override suspend fun getOTPResponse(
        header: HashMap<String, String>,
        params: JsonObject
    ): com.sorabh.grabfood.api_response_classes.otp_response.Data? {
        return networkInterface.getOTPResponse(header, params).body()?.data
    }

    // Home Fragment

    override suspend fun getRestaurantsList(header: HashMap<String, String>): Result<Restaurant> {
        val response = networkInterface.getRestaurantsList(header)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(),response.code(),response.message())
            else
                Result.Error(response.code(),response.message())
        }catch (e:Exception){
            Result.Error(response.code(),e.message ?: Constants.NETWORK_ERROR)
        }
    }

    override suspend fun getMenuList(
        header: HashMap<String, String>,
        restaurant_id: String
    ): Result<RestaurantMenu> {
        val response = networkInterface.getRestaurantMenu(header, restaurant_id)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(),response.code(),response.message())
            else
                Result.Error(response.code(),response.message())
        }catch (e:Exception){
            Result.Error(response.code(),response.message())
        }

    }

    // Cart Adapter
    override suspend fun placeOder(
        header: HashMap<String, String>,
        params: JsonObject
    ): Result<OderConfirmation> {
        val response = networkInterface.placeOder(header, params)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(), response.code(), response.message())
            else
                Result.Error(response.code(), response.message())
        } catch (e: Exception) {
            Result.Error(response.code(), e.message ?: Constants.NETWORK_ERROR)
        }
    }

    // Oder Fragment
    override suspend fun getOderHistory(
        header: HashMap<String, String>,
        user_id: String?
    ): Result<OderHistory> {
        val response = networkInterface.getOderHistory(header, user_id)
        return try {
            if (response.isSuccessful)
                Result.Success(response.body(), response.code(), response.message())
            else
                Result.Error(response.code(), response.message())
        } catch (e: Exception) {
            Result.Error(response.code(), e.message ?: Constants.NETWORK_ERROR)
        }
    }
}