package com.sorabh.grabfood.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.util.RestaurantDiffUtil;
import kotlinx.coroutines.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0016\u0010\u001f\u001a\u00020\u00182\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "onFavoriteButtonClicked", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnFavoriteButtonClicked;", "getOnFavoriteButtonClicked", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnFavoriteButtonClicked;", "setOnFavoriteButtonClicked", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnFavoriteButtonClicked;)V", "restaurantsClicked", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "getRestaurantsClicked", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "setRestaurantsClicked", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;)V", "restaurantsList", "", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateRestaurantsList", "newList", "", "app_debug"})
public final class RestaurantHomeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.RestaurantViewHolder> {
    private final com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository = null;
    @org.jetbrains.annotations.Nullable()
    private com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked restaurantsClicked;
    @org.jetbrains.annotations.Nullable()
    private com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked onFavoriteButtonClicked;
    private java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> restaurantsList;
    
    @javax.inject.Inject()
    public RestaurantHomeAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked getRestaurantsClicked() {
        return null;
    }
    
    public final void setRestaurantsClicked(@org.jetbrains.annotations.Nullable()
    com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked getOnFavoriteButtonClicked() {
        return null;
    }
    
    public final void setOnFavoriteButtonClicked(@org.jetbrains.annotations.Nullable()
    com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnFavoriteButtonClicked p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sorabh.grabfood.ui.adapter.RestaurantViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.RestaurantViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateRestaurantsList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> newList) {
    }
}