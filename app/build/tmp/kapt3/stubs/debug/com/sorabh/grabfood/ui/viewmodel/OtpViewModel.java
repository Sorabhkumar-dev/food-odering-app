package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetOTPUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0007J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00072\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u000f0\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u001e"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/OtpViewModel;", "Landroidx/lifecycle/ViewModel;", "getOTPUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetOTPUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetOTPUseCase;)V", "confirmPasswordFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getConfirmPasswordFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "passwordFlow", "getPasswordFlow", "userOTPFlow", "getUserOTPFlow", "getOtp", "", "postModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onOTPGet", "Lkotlin/Function1;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/otp_response/OTPResponse;", "onConfirmPasswordChanged", "confirmPassword", "onPasswordChanged", "password", "onUserOTPChanged", "otp", "setupApiCall", "phone", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class OtpViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetOTPUseCase getOTPUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userOTPFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> passwordFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> confirmPasswordFlow = null;
    
    @javax.inject.Inject
    public OtpViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetOTPUseCase getOTPUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserOTPFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getPasswordFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getConfirmPasswordFlow() {
        return null;
    }
    
    public final void onUserOTPChanged(@org.jetbrains.annotations.NotNull
    java.lang.String otp) {
    }
    
    public final void onPasswordChanged(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void onConfirmPasswordChanged(@org.jetbrains.annotations.NotNull
    java.lang.String confirmPassword) {
    }
    
    public final void setupApiCall(@org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse>, kotlin.Unit> onOTPGet) {
    }
    
    private final void getOtp(com.sorabh.grabfood.domain.model.post.OderPostModel postModel, kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse>, kotlin.Unit> onOTPGet) {
    }
}