package com.sorabh.grabfood.domain.network_api;

import com.google.gson.JsonObject;
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse;
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse;
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory;
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation;
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu;
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse;
import retrofit2.Response;
import retrofit2.http.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJG\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJG\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJI\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\u0016\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J=\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019JG\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJG\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032$\b\u0001\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/sorabh/grabfood/domain/network_api/NetworkInterface;", "", "getForgotResponse", "Lretrofit2/Response;", "Lcom/sorabh/grabfood/api_response_classes/forgot_response/ForgotResponse;", "header", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lcom/google/gson/JsonObject;", "(Ljava/util/HashMap;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginDetails", "Lcom/sorabh/grabfood/domain/model/login_respones/LoginResponse;", "getOTPResponse", "Lcom/sorabh/grabfood/api_response_classes/otp_response/OTPResponse;", "getOderHistory", "Lcom/sorabh/grabfood/domain/model/oder_history_response/OderHistory;", "user_id", "(Ljava/util/HashMap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRestaurantMenu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/RestaurantMenu;", "restaurant_id", "getRestaurantsList", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Restaurant;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignUpDetails", "Lcom/sorabh/grabfood/api_response_classes/signup_reponse/SignUpResponse;", "placeOder", "Lcom/sorabh/grabfood/domain/model/oder_respones/OderConfirmation;", "app_debug"})
public abstract interface NetworkInterface {
    
    @retrofit2.http.POST(value = "login/fetch_result")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLoginDetails(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.domain.model.login_respones.LoginResponse>> $completion);
    
    @retrofit2.http.POST(value = "register/fetch_result")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getSignUpDetails(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>> $completion);
    
    @retrofit2.http.POST(value = "forgot_password/fetch_result")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getForgotResponse(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>> $completion);
    
    @retrofit2.http.POST(value = "reset_password/fetch_result")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOTPResponse(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse>> $completion);
    
    @retrofit2.http.GET(value = "restaurants/fetch_result/")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRestaurantsList(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> $completion);
    
    @retrofit2.http.GET(value = "restaurants/fetch_result/{id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRestaurantMenu(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull
    java.lang.String restaurant_id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu>> $completion);
    
    @retrofit2.http.POST(value = "place_order/fetch_result/")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object placeOder(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> $completion);
    
    @retrofit2.http.GET(value = "orders/fetch_result/{user_id}")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOderHistory(@retrofit2.http.HeaderMap
    @org.jetbrains.annotations.NotNull
    java.util.HashMap<java.lang.String, java.lang.String> header, @retrofit2.http.Path(value = "user_id")
    @org.jetbrains.annotations.Nullable
    java.lang.String user_id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> $completion);
}