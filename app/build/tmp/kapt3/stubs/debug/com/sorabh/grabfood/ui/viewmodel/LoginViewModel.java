package com.sorabh.grabfood.ui.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse;
import com.sorabh.grabfood.domain.model.post.LoginPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0019\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010\'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0019\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "getLoginResponseUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetLoginResponseUseCase;", "preferenceDataStore", "Lcom/sorabh/grabfood/domain/datastore/PreferenceData;", "(Lcom/sorabh/grabfood/domain/usecase/GetLoginResponseUseCase;Lcom/sorabh/grabfood/domain/datastore/PreferenceData;)V", "userPasswordFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getUserPasswordFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "userPhoneFlow", "getUserPhoneFlow", "getLoginDetails", "", "loginPostModel", "Lcom/sorabh/grabfood/domain/model/post/LoginPostModel;", "onLoginSuccess", "Lkotlin/Function0;", "login", "onUserPasswordChanged", "password", "onUserPhoneChanged", "phone", "saveLoginData", "loginData", "Lcom/sorabh/grabfood/domain/model/login_respones/LoginResponse;", "writeAddress", "address", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeEmail", "email", "writeIsLogin", "isLogin", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeMobileNumber", "mobileNumber", "writeName", "name", "writeUserId", "userId", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase getLoginResponseUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.datastore.PreferenceData preferenceDataStore = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userPhoneFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userPasswordFlow = null;
    
    @javax.inject.Inject
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase getLoginResponseUseCase, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.datastore.PreferenceData preferenceDataStore) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserPhoneFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserPasswordFlow() {
        return null;
    }
    
    public final void onUserPhoneChanged(@org.jetbrains.annotations.NotNull
    java.lang.String phone) {
    }
    
    public final void onUserPasswordChanged(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void login(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoginSuccess) {
    }
    
    private final void getLoginDetails(com.sorabh.grabfood.domain.model.post.LoginPostModel loginPostModel, kotlin.jvm.functions.Function0<kotlin.Unit> onLoginSuccess) {
    }
    
    private final void saveLoginData(com.sorabh.grabfood.domain.model.login_respones.LoginResponse loginData) {
    }
    
    private final java.lang.Object writeName(java.lang.String name, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object writeAddress(java.lang.String address, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object writeEmail(java.lang.String email, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object writeMobileNumber(java.lang.String mobileNumber, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object writeUserId(java.lang.String userId, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object writeIsLogin(boolean isLogin, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}