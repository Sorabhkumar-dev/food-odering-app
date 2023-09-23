package com.sorabh.grabfood.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentHomeBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment;
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/home/HomeFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentHomeBinding;", "restaurantHomeAdapter", "Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "getRestaurantHomeAdapter", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "setRestaurantHomeAdapter", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setOnClickListener", "", "setupObserver", "startupInitializer", "app_debug"})
public final class HomeFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    private com.sorabh.grabfood.databinding.FragmentHomeBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter restaurantHomeAdapter;
    
    public HomeFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.HomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter getRestaurantHomeAdapter() {
        return null;
    }
    
    public final void setRestaurantHomeAdapter(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setOnClickListener() {
    }
    
    private final void startupInitializer(android.view.LayoutInflater inflater) {
    }
    
    private final void setupObserver() {
    }
}