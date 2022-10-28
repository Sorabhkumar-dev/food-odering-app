package com.sorabh.grabfood.domain.repository;

import com.google.gson.JsonObject;
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse;
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse;
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse;
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse;
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory;
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu;
import com.sorabh.grabfood.domain.network_api.NetworkInterface;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.util.Constants;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JC\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJC\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\u0013\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014JC\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJE\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J;\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJC\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJC\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00062\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/sorabh/grabfood/domain/repository/NetworkRepositoryImpl;", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "networkInterface", "Lcom/sorabh/grabfood/domain/network_api/NetworkInterface;", "(Lcom/sorabh/grabfood/domain/network_api/NetworkInterface;)V", "getForgotResponse", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/forgot_response/ForgotResponse;", "header", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lcom/google/gson/JsonObject;", "(Ljava/util/HashMap;Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginDetails", "Lcom/sorabh/grabfood/domain/model/login_respones/LoginResponse;", "getMenuList", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/RestaurantMenu;", "restaurant_id", "(Ljava/util/HashMap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOTPResponse", "Lcom/sorabh/grabfood/api_response_classes/otp_response/OTPResponse;", "getOderHistory", "Lcom/sorabh/grabfood/domain/model/oder_history_response/OderHistory;", "user_id", "getRestaurantsList", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Restaurant;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignUpDetails", "Lcom/sorabh/grabfood/api_response_classes/signup_reponse/SignUpResponse;", "placeOder", "Lcom/sorabh/grabfood/domain/model/oder_respones/OderConfirmation;", "app_debug"})
public final class NetworkRepositoryImpl implements com.sorabh.grabfood.domain.repository.NetworkRepository {
    private final com.sorabh.grabfood.domain.network_api.NetworkInterface networkInterface = null;
    
    @javax.inject.Inject()
    public NetworkRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.network_api.NetworkInterface networkInterface) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getLoginDetails(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.login_respones.LoginResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getSignUpDetails(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getForgotResponse(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getOTPResponse(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getRestaurantsList(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getMenuList(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    java.lang.String restaurant_id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object placeOder(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.NotNull()
    com.google.gson.JsonObject params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getOderHistory(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.String> header, @org.jetbrains.annotations.Nullable()
    java.lang.String user_id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> continuation) {
        return null;
    }
}