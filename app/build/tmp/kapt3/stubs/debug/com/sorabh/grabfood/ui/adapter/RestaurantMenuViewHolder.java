package com.sorabh.grabfood.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "restaurantMenuCardViewBinding", "Lcom/sorabh/grabfood/databinding/RestaurantMenuCardviewBinding;", "(Lcom/sorabh/grabfood/databinding/RestaurantMenuCardviewBinding;)V", "getRestaurantMenuCardViewBinding", "()Lcom/sorabh/grabfood/databinding/RestaurantMenuCardviewBinding;", "OnMenuButtonClickedListener", "app_debug"})
public final class RestaurantMenuViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding restaurantMenuCardViewBinding = null;
    
    public RestaurantMenuViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding restaurantMenuCardViewBinding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding getRestaurantMenuCardViewBinding() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuViewHolder$OnMenuButtonClickedListener;", "", "onMenuButtonClicked", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "app_debug"})
    public static abstract interface OnMenuButtonClickedListener {
        
        public abstract void onMenuButtonClicked(@org.jetbrains.annotations.NotNull()
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu);
    }
}