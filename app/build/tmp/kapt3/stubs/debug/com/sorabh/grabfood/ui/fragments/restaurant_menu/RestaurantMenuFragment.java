package com.sorabh.grabfood.ui.fragments.restaurant_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding;
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter;
import com.sorabh.grabfood.ui.fragments.cart.CartFragment;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/restaurant_menu/RestaurantMenuFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "(Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;)V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentRestaurantMenuBinding;", "repository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "getRepository", "()Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "setRepository", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "restaurantMenuAdapter", "Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuAdapter;", "getRestaurantMenuAdapter", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuAdapter;", "setRestaurantMenuAdapter", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuAdapter;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/RestaurantMenuViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/RestaurantMenuViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupObserver", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class RestaurantMenuFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    private final com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish = null;
    private com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding binding;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.NetworkRepository repository;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter restaurantMenuAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public RestaurantMenuFragment(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.NetworkRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter getRestaurantMenuAdapter() {
        return null;
    }
    
    public final void setRestaurantMenuAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter p0) {
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setupObserver() {
    }
}