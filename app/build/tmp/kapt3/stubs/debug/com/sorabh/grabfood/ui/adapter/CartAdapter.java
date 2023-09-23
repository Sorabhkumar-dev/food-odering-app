package com.sorabh.grabfood.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.databinding.CartAdapterLayoutBinding;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/CartAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/CartViewHolder;", "()V", "menuList", "", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "onOderButtonClickedListener", "Lcom/sorabh/grabfood/ui/adapter/CartViewHolder$OnOderButtonClickedListener;", "getOnOderButtonClickedListener", "()Lcom/sorabh/grabfood/ui/adapter/CartViewHolder$OnOderButtonClickedListener;", "setOnOderButtonClickedListener", "(Lcom/sorabh/grabfood/ui/adapter/CartViewHolder$OnOderButtonClickedListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateMenuList", "newMenuList", "", "app_debug"})
public final class CartAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.CartViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> menuList;
    @org.jetbrains.annotations.Nullable
    private com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener onOderButtonClickedListener;
    
    @javax.inject.Inject
    public CartAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener getOnOderButtonClickedListener() {
        return null;
    }
    
    public final void setOnOderButtonClickedListener(@org.jetbrains.annotations.Nullable
    com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.sorabh.grabfood.ui.adapter.CartViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.CartViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateMenuList(@org.jetbrains.annotations.Nullable
    java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> newMenuList) {
    }
}