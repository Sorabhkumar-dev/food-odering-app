package com.sorabh.grabfood.ui.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.RestaurantMenuCardviewBinding;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0016J\u0016\u0010!\u001a\u00020\u001a2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010#R;\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR;\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR;\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantMenuViewHolder;", "()V", "deleteMenu", "Lkotlin/Function2;", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "Lkotlin/coroutines/Continuation;", "", "", "getDeleteMenu", "()Lkotlin/jvm/functions/Function2;", "setDeleteMenu", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "insertMenu", "getInsertMenu", "setInsertMenu", "isMenuSaved", "", "setMenuSaved", "restaurantMenuList", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateRestaurantMenu", "newMenu", "", "app_debug"})
public final class RestaurantMenuAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> restaurantMenuList;
    public kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> insertMenu;
    public kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> deleteMenu;
    public kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> isMenuSaved;
    
    @javax.inject.Inject
    public RestaurantMenuAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> getInsertMenu() {
        return null;
    }
    
    public final void setInsertMenu(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> getDeleteMenu() {
        return null;
    }
    
    public final void setDeleteMenu(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> isMenuSaved() {
        return null;
    }
    
    public final void setMenuSaved(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateRestaurantMenu(@org.jetbrains.annotations.Nullable
    java.util.List<com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu> newMenu) {
    }
}