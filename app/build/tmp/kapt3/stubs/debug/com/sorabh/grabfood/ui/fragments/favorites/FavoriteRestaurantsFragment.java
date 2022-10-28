package com.sorabh.grabfood.ui.fragments.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter;
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/favorites/FavoriteRestaurantsFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnFavoriteButtonClicked;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FavoriteRestaurantsFragmentBinding;", "favoriteRestaurantList", "", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "getLocalDBRepository", "()Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "setLocalDBRepository", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "restaurantHomeAdapter", "Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "getRestaurantHomeAdapter", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "setRestaurantHomeAdapter", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;)V", "getFavoriteRestaurantList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFavoriteButtonClicked", "", "dish", "onRestaurantsClicked", "setupData", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class FavoriteRestaurantsFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment implements com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked, com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked {
    private com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding binding;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter restaurantHomeAdapter;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository;
    private java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> favoriteRestaurantList;
    
    public FavoriteRestaurantsFragment() {
        super();
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
    
    private final void startupInitializer() {
    }
    
    private final void setupData() {
    }
    
    @java.lang.Override()
    public void onRestaurantsClicked(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
    }
    
    @java.lang.Override()
    public void onFavoriteButtonClicked(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish) {
    }
    
    private final java.lang.Object getFavoriteRestaurantList(kotlin.coroutines.Continuation<? super java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish>> continuation) {
        return null;
    }
}