package com.sorabh.grabfood.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001eH\u0016J\u0016\u0010\'\u001a\u00020 2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010)R;\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR;\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR;\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005X\u0086.\u00f8\u0001\u0000\u00a2\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/RestaurantHomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder;", "()V", "deleteRestaurant", "Lkotlin/Function2;", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "Lkotlin/coroutines/Continuation;", "", "", "getDeleteRestaurant", "()Lkotlin/jvm/functions/Function2;", "setDeleteRestaurant", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "insertRestaurant", "getInsertRestaurant", "setInsertRestaurant", "isRestaurantStored", "", "setRestaurantStored", "restaurantsClicked", "Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "getRestaurantsClicked", "()Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;", "setRestaurantsClicked", "(Lcom/sorabh/grabfood/ui/adapter/RestaurantViewHolder$OnRestaurantsClicked;)V", "restaurantsList", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateRestaurantsList", "newList", "", "app_debug"})
public final class RestaurantHomeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.RestaurantViewHolder> {
    @org.jetbrains.annotations.Nullable
    private com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked restaurantsClicked;
    public kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> insertRestaurant;
    public kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> deleteRestaurant;
    public kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> isRestaurantStored;
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> restaurantsList;
    
    @javax.inject.Inject
    public RestaurantHomeAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked getRestaurantsClicked() {
        return null;
    }
    
    public final void setRestaurantsClicked(@org.jetbrains.annotations.Nullable
    com.sorabh.grabfood.ui.adapter.RestaurantViewHolder.OnRestaurantsClicked p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> getInsertRestaurant() {
        return null;
    }
    
    public final void setInsertRestaurant(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> getDeleteRestaurant() {
        return null;
    }
    
    public final void setDeleteRestaurant(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super com.sorabh.grabfood.domain.model.reataurants_home_response.Dish, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.jvm.functions.Function2<java.lang.String, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> isRestaurantStored() {
        return null;
    }
    
    public final void setRestaurantStored(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.sorabh.grabfood.ui.adapter.RestaurantViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.RestaurantViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    public final void updateRestaurantsList(@org.jetbrains.annotations.Nullable
    java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> newList) {
    }
}