package com.sorabh.grabfood.domain.network_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetFoodClient {
    private const val BASE_URL = "http://13.235.250.119/v2/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}