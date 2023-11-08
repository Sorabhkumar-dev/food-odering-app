package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetSignupUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u001a0\u001eH\u0002J\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0007J\u000e\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u0007J\u0006\u0010,\u001a\u00020\u001aJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u0007J \u0010/\u001a\u00020\u001a2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\u001a0\u001eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\t\u00a8\u00060"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "getSignupUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetSignupUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetSignupUseCase;)V", "confirmPasswordFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getConfirmPasswordFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "confirmPasswordVisible", "", "getConfirmPasswordVisible", "deliveryAddressFlow", "getDeliveryAddressFlow", "passwordFlow", "getPasswordFlow", "passwordVisible", "getPasswordVisible", "userEmailFlow", "getUserEmailFlow", "userMobileFlow", "getUserMobileFlow", "userNameFlow", "getUserNameFlow", "getSignUpData", "", "oderPostModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onSignUp", "Lkotlin/Function1;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/signup_reponse/SignUpResponse;", "isSignUpDataEvaluated", "onAddressChanged", "address", "onConfirmPasswordChanged", "confirmPassword", "onEmailChanged", "email", "onMobileChanged", "mobile", "onPasswordChanged", "password", "onPasswordVisible", "onUserNameChanged", "name", "signUp", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SignUpViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetSignupUseCase getSignupUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> deliveryAddressFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userMobileFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userEmailFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userNameFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> confirmPasswordFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> passwordFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> passwordVisible = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> confirmPasswordVisible = null;
    
    @javax.inject.Inject
    public SignUpViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetSignupUseCase getSignupUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getDeliveryAddressFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserMobileFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserEmailFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserNameFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getConfirmPasswordFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getPasswordFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getPasswordVisible() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> getConfirmPasswordVisible() {
        return null;
    }
    
    public final void onUserNameChanged(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void onMobileChanged(@org.jetbrains.annotations.NotNull
    java.lang.String mobile) {
    }
    
    public final void onEmailChanged(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    public final void onAddressChanged(@org.jetbrains.annotations.NotNull
    java.lang.String address) {
    }
    
    public final void onPasswordChanged(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void onConfirmPasswordChanged(@org.jetbrains.annotations.NotNull
    java.lang.String confirmPassword) {
    }
    
    public final void onPasswordVisible() {
    }
    
    public final boolean isSignUpDataEvaluated() {
        return false;
    }
    
    public final void signUp(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>, kotlin.Unit> onSignUp) {
    }
    
    private final void getSignUpData(com.sorabh.grabfood.domain.model.post.OderPostModel oderPostModel, kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>, kotlin.Unit> onSignUp) {
    }
}