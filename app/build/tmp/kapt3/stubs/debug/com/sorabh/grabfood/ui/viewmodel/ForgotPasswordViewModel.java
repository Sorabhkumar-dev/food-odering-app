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
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\r0\u000fJ*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\r0\u000fH\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/ForgotPasswordViewModel;", "Landroidx/lifecycle/ViewModel;", "getForgotPasswordUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetForgotPasswordUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetForgotPasswordUseCase;)V", "userEmailFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getUserEmailFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "userPhoneFlow", "getUserPhoneFlow", "forgotPassword", "", "onResult", "Lkotlin/Function1;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/api_response_classes/forgot_response/ForgotResponse;", "getForgotPassword", "oderPostModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onEmailChanged", "email", "onUserPhoneChanged", "phone", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ForgotPasswordViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase getForgotPasswordUseCase = null;
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