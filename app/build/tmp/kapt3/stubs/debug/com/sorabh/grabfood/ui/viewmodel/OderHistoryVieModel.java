package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory;
import com.sorabh.grabfood.domain.model.post.OderHistoryPost;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/OderHistoryVieModel;", "Landroidx/lifecycle/ViewModel;", "getOderHistoryUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;", "(Lcom/sorabh/grabfood/domain/usecase/GetOderHistoryUseCase;)V", "_oderHistoryFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/oder_history_response/OderHistory;", "oderHistoryFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getOderHistoryFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getOderHistory", "", "oderHistoryPost", "Lcom/sorabh/grabfood/domain/model/post/OderHistoryPost;", "app_debug"})
public final class OderHistoryVieModel extends androidx.lifecycle.ViewModel {
    private final com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase getOderHistoryUseCase = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> _oderHistoryFlow = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> oderHistoryFlow = null;
    
    @javax.inject.Inject()
    public OderHistoryVieModel(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase getOderHistoryUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_history_response.OderHistory>> getOderHistoryFlow() {
        return null;
    }
    
    public final void getOderHistory(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.post.OderHistoryPost oderHistoryPost) {
    }
}