package com.sorabh.grabfood.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/RestaurantMenuViewModel;", "Landroidx/lifecycle/ViewModel;", "getRestaurantMenuUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetRestaurantMenuUseCase;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "(Lcom/sorabh/grabfood/domain/usecase/GetRestaurantMenuUseCase;Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "_restaurantMenuFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/RestaurantMenu;", "restaurantMenuFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getRestaurantMenuFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteMenu", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRestaurantMenus", "", "restaurantMenuPostModel", "Lcom/sorabh/grabfood/domain/model/post/RestaurantMenuPostModel;", "restaurantId", "", "insertMenu", "isMenuSaved", "Lkotlinx/coroutines/flow/Flow;", "", "id", "onMenuClicked", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class RestaurantMenuViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase getRestaurantMenuUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu>> _restaurantMenuFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu>> restaurantMenuFlow = null;
    
    @javax.inject.Inject
    public RestaurantMenuViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase getRestaurantMenuUseCase, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.restaurant_menu_response.RestaurantMenu>> getRestaurantMenuFlow() {
        return null;
    }
    
    public final void getRestaurantMenus(@org.jetbrains.annotations.NotNull
    java.lang.String restaurantId) {
    }
    
    private final void getRestaurantMenus(com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel restaurantMenuPostModel) {
    }
    
    public final void onMenuClicked(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu) {
    }
    
    private final java.lang.Object insertMenu(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object deleteMenu(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> isMenuSaved(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}