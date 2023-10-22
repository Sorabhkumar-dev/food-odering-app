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

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020!0%J\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020\nJ\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\nJ\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020!J\u000e\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\nJ \u00104\u001a\u00020!2\u0018\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020!0%R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\f\u00a8\u00065"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/SignUpViewModel;", "Landroidx/lifecycle/ViewModel;", "getSignupUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetSignupUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetSignupUseCase;)V", "_signUpFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/signup_reponse/SignUpResponse;", "confirmPasswordFlow", "", "getConfirmPasswordFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "confirmPasswordVisible", "", "getConfirmPasswordVisible", "deliveryAddressFlow", "getDeliveryAddressFlow", "passwordFlow", "getPasswordFlow", "passwordVisible", "getPasswordVisible", "signUpFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getSignUpFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "userEmailFlow", "getUserEmailFlow", "userMobileFlow", "getUserMobileFlow", "userNameFlow", "getUserNameFlow", "getSignUpData", "", "oderPostModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onSignUp", "Lkotlin/Function1;", "isSignUpDataEvaluated", "onAddressChanged", "address", "onConfirmPasswordChanged", "confirmPassword", "onEmailChanged", "email", "onMobileChanged", "mobile", "onPasswordChanged", "password", "onPasswordVisible", "onUserNameChanged", "name", "signUp", "app_debug"})
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
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>> _signUpFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>> signUpFlow = null;
    
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
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>> getSignUpFlow() {
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
    
    public final void getSignUpData(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.post.OderPostModel oderPostModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse>, kotlin.Unit> onSignUp) {
    }
}