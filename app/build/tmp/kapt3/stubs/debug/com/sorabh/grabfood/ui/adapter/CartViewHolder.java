package com.sorabh.grabfood.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.databinding.CartAdapterLayoutBinding;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/CartViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cartAdapterLayoutBinding", "Lcom/sorabh/grabfood/databinding/CartAdapterLayoutBinding;", "(Lcom/sorabh/grabfood/databinding/CartAdapterLayoutBinding;)V", "getCartAdapterLayoutBinding", "()Lcom/sorabh/grabfood/databinding/CartAdapterLayoutBinding;", "OnOderButtonClickedListener", "app_debug"})
public final class CartViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull
    private final com.sorabh.grabfood.databinding.CartAdapterLayoutBinding cartAdapterLayoutBinding = null;
    
    public CartViewHolder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.databinding.CartAdapterLayoutBinding cartAdapterLayoutBinding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.databinding.CartAdapterLayoutBinding getCartAdapterLayoutBinding() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/CartViewHolder$OnOderButtonClickedListener;", "", "onOderButtonClicked", "", "menu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "app_debug"})
    public static abstract interface OnOderButtonClickedListener {
        
        public abstract void onOderButtonClicked(@org.jetbrains.annotations.NotNull
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu);
    }
}