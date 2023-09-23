package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory;
import com.sorabh.grabfood.domain.model.post.OderHistoryPost;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/OderHistoryVieModel;", "Landroidx/lifecycle/ViewModel;", "getOderHistoryUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;", "preferenceData", "Lcom/sorabh/grabfood/domain/datastore/PreferenceData;", "(Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;Lcom/sorabh/grabfood/domain/datastore/PreferenceData;)V", "_oderHistoryFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/oder_history_response/OderHistory;", "oderHistoryFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOderHistoryFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "userIdFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getUserIdFlow", "()Lkotlinx/coroutines/flow/Flow;", "getOderHistory", "", "oderHistoryPost", "Lcom/sorabh/grabfood/domain/model/post/OderHistoryPost;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class OderHistoryVieModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase getOderHistoryUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> _oderHistoryFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> oderHistoryFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> userIdFlow = null;
    
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
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getUserIdFlow() {
        return null;
    }
    
    public final void getOderHistory(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.post.OderHistoryPost oderHistoryPost) {
    }
}