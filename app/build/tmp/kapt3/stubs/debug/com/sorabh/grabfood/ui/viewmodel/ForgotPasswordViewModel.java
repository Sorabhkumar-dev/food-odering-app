package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0013\u001a\u00020\u00142\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00140\u0016J*\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00140\u0016H\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/ForgotPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "getForgotPasswordUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetForgotPasswordUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetForgotPasswordUseCase;)V", "_forgetPasswordFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/forgot_response/ForgotResponse;", "forgetPasswordFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getForgetPasswordFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "userEmailFlow", "", "getUserEmailFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "userPhoneFlow", "getUserPhoneFlow", "forgotPassword", "", "onResult", "Lkotlin/Function1;", "getForgotPassword", "oderPostModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onEmailChanged", "email", "onUserPhoneChanged", "phone", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ForgotPasswordViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase getForgotPasswordUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>> _forgetPasswordFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>> forgetPasswordFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userPhoneFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> userEmailFlow = null;
    
    @javax.inject.Inject
    public ForgotPasswordViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase getForgotPasswordUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>> getForgetPasswordFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserPhoneFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getUserEmailFlow() {
        return null;
    }
    
    public final void onUserPhoneChanged(@org.jetbrains.annotations.NotNull
    java.lang.String phone) {
    }
    
    public final void onEmailChanged(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    public final void forgotPassword(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>, kotlin.Unit> onResult) {
    }
    
    private final void getForgotPassword(com.sorabh.grabfood.domain.model.post.OderPostModel oderPostModel, kotlin.jvm.functions.Function1<? super com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse>, kotlin.Unit> onResult) {
    }
}