package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020 H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J7\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\'2\u001c\u0010(\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0*\u0012\u0006\u0012\u0004\u0018\u00010+0)H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\fR\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "getOderConfirmationUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetOderConfirmationUseCase;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "preferenceData", "Lcom/sorabh/grabfood/domain/datastore/PreferenceData;", "(Lcom/sorabh/grabfood/domain/usecase/GetOderConfirmationUseCase;Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;Lcom/sorabh/grabfood/domain/datastore/PreferenceData;)V", "_menuFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "_oderConfirmationFlow", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/oder_respones/OderConfirmation;", "menuFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getMenuFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "oderConfirmationFlow", "getOderConfirmationFlow", "userIdFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getUserIdFlow", "()Lkotlinx/coroutines/flow/Flow;", "deleteMenu", "", "menu", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenu", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isMenuSaved", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOder", "oderPostModel", "Lcom/sorabh/grabfood/domain/model/post/OderPostModel;", "onOderPlaced", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/sorabh/grabfood/domain/model/post/OderPostModel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase getOderConfirmationUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> _oderConfirmationFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> oderConfirmationFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> _menuFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> menuFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.lang.String> userIdFlow = null;
    
    @javax.inject.Inject
    public CartViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase getOderConfirmationUseCase, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.datastore.PreferenceData preferenceData) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation>> getOderConfirmationFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu>> getMenuFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getUserIdFlow() {
        return null;
    }
    
    public final void placeOrder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object placeOder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.post.OderPostModel oderPostModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> onOderPlaced, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object deleteMenu(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object isMenuSaved(java.lang.String id, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object getMenu(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}