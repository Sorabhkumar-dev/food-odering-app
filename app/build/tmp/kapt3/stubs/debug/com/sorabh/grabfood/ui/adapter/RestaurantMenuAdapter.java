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

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuViewHolder;", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "restaurantMenuList", "", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateRestaurantMenu", "newMenu", "", "app_debug"})
public final class RestaurantMenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder> {
    private final com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository = null;
    private java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> restaurantMenuList;
    
    @javax.inject.Inject()
    public RestaurantMenuAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateRestaurantMenu(@org.jetbrains.annotations.Nullable()
    java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> newMenu) {
    }
}