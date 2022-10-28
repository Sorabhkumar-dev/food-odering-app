package com.sorabh.grabfood.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentHomeBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment;
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\'H\u0002J\u0010\u0010+\u001a\u00020\'2\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006,"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/home/HomeFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentHomeBinding;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "getLocalDBRepository", "()Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "setLocalDBRepository", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "repository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "getRepository", "()Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "setRepository", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "restaurantHomeAdapter", "Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "getRestaurantHomeAdapter", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "setRestaurantHomeAdapter", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRestaurantsClicked", "", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "setupObserver", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class HomeFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment implements com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked {
    private com.sorabh.grabfood.databinding.FragmentHomeBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.NetworkRepository repository;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter restaurantHomeAdapter;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository;
    
    public HomeFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.HomeViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.NetworkRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter getRestaurantHomeAdapter() {
        return null;
    }
    
    public final void setRestaurantHomeAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.LocalDBRepository getLocalDBRepository() {
        return null;
    }
    
    public final void setLocalDBRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.LocalDBRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitializer(android.view.LayoutInflater inflater) {
    }
    
    @java.lang.Override()
    public void onRestaurantsClicked(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
    }
    
    private final void setupObserver() {
    }
}