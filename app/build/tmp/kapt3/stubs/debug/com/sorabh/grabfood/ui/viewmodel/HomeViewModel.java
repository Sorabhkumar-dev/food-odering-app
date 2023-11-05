package com.sorabh.grabfood.ui.viewmodel;

import androidx.compose.material.icons.Icons;
import androidx.lifecycle.ViewModel;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.domain.local_model.tab.HomeTab;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\rR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/sorabh/grabfood/ui/viewmodel/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "getRestaurantUseCase", "Lcom/sorabh/grabfood/domain/usecase/GetRestaurantUseCase;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "(Lcom/sorabh/grabfood/domain/usecase/GetRestaurantUseCase;Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "_restaurantFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/sorabh/grabfood/domain/network_api/Result;", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Restaurant;", "homeTabs", "", "Lcom/sorabh/grabfood/domain/local_model/tab/HomeTab;", "getHomeTabs", "()Ljava/util/List;", "restaurantFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getRestaurantFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedTab", "getSelectedTab", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getRestaurants", "", "isDishStored", "Lkotlinx/coroutines/flow/Flow;", "", "id", "", "onFavoriteIconBtnClick", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "onTabChanged", "tab", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase getRestaurantUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> _restaurantFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> restaurantFlow = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sorabh.grabfood.domain.local_model.tab.HomeTab> homeTabs = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.local_model.tab.HomeTab> selectedTab = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase getRestaurantUseCase, @org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.sorabh.grabfood.domain.network_api.Result<com.sorabh.grabfood.domain.model.reataurants_home_response.Restaurant>> getRestaurantFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sorabh.grabfood.domain.local_model.tab.HomeTab> getHomeTabs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.MutableStateFlow<com.sorabh.grabfood.domain.local_model.tab.HomeTab> getSelectedTab() {
        return null;
    }
    
    public final void onTabChanged(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.local_model.tab.HomeTab tab) {
    }
    
    public final void getRestaurants() {
    }
    
    public final void onFavoriteIconBtnClick(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> isDishStored(@org.jetbrains.annotations.NotNull
    java.lang.String id) {
        return null;
    }
}