package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory;
import com.sorabh.grabfood.domain.model.post.OderHistoryPost;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/OderHistoryVieModel;", "Landroidx/lifecycle/ViewModel;", "getOderHistoryUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;", "preferenceData", "Lcom/sorabh/grabfood/domain/datastore/PreferenceData;", "(Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;Lcom/sorabh/grabfood/domain/datastore/PreferenceData;)V", "_oderHistoryFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/oder_history_response/OderHistory;", "oderHistoryFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOderHistoryFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getOderHistory", "", "oderHistoryPost", "Lcom/sorabh/grabfood/domain/model/post/OderHistoryPost;", "(Lcom/sorabh/grabfood/domain/model/post/OderHistoryPost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupApiCall", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class OderHistoryVieModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase getOderHistoryUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.datastore.PreferenceData preferenceData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> _oderHistoryFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> oderHistoryFlow = null;
    
    @javax.inject.Inject
    public OderHistoryVieModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase getOderHistoryUseCase, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.datastore.PreferenceData preferenceData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> getOderHistoryFlow() {
        return null;
    }
    
    private final void setupApiCall() {
    }
    
    private final java.lang.Object getOderHistory(com.sorabh.grabfood.domain.model.post.OderHistoryPost oderHistoryPost, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}