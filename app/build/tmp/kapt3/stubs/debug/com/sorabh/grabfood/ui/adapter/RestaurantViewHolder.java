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

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0007\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/sorabh/grabfood/databinding/RestaurantsHomeCardviewBinding;", "(Lcom/sorabh/grabfood/databinding/RestaurantsHomeCardviewBinding;)V", "getBinding", "()Lcom/sorabh/grabfood/databinding/RestaurantsHomeCardviewBinding;", "OnFavoriteButtonClicked", "OnRestaurantsClicked", "app_debug"})
public final class RestaurantViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding binding = null;
    
    public RestaurantViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding binding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding getBinding() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnFavoriteButtonClicked;", "", "onFavoriteButtonClicked", "", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "app_debug"})
    public static abstract interface OnFavoriteButtonClicked {
        
        public abstract void onFavoriteButtonClicked(@org.jetbrains.annotations.NotNull()
        com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "", "onRestaurantsClicked", "", "dish", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "app_debug"})
    public static abstract interface OnRestaurantsClicked {
        
        public abstract void onRestaurantsClicked(@org.jetbrains.annotations.NotNull()
        com.sorabh.grabfood.domain.model.reataurants_home_response.Dish dish);
    }
}