package com.sorabh.grabfood.ui.fragments.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment;
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/favorites/FavoriteRestaurantsFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FavoriteRestaurantsFragmentBinding;", "restaurantHomeAdapter", "Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "getRestaurantHomeAdapter", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "setRestaurantHomeAdapter", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/FavoriteRestaurantsViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/FavoriteRestaurantsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRestaurantsClicked", "", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "setupData", "setupEmptyView", "isShow", "", "startupInitializer", "app_debug"})
public final class FavoriteRestaurantsFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment implements com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked {
    private com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @javax.inject.Inject
    public com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter restaurantHomeAdapter;
    
    public FavoriteRestaurantsFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel getViewModel() {
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
    
    private final void startupInitializer() {
    }
    
    private final void setupData() {
    }
    
    private final void setupEmptyView(boolean isShow) {
    }
    
    @java.lang.Override
    public void onRestaurantsClicked(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
    }
}