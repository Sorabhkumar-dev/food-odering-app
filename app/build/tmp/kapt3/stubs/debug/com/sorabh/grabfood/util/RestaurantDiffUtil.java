package com.sorabh.grabfood.util;

import androidx.recyclerview.widget.DiffUtil;
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/sorabh/grabfood/util/RestaurantDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "newList", "", "Lcom/sorabh/grabfood/domain/model/reataurants_home_response/Dish;", "oldList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_debug"})
public final class RestaurantDiffUtil extends androidx.recyclerview.widget.DiffUtil.Callback {
    private final java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> newList = null;
    private final java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> oldList = null;
    
    public RestaurantDiffUtil(@org.jetbrains.annotations.Nullable()
    java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> newList, @org.jetbrains.annotations.Nullable()
    java.util.List<com.sorabh.grabfood.domain.model.reataurants_home_response.Dish> oldList) {
        super();
    }
    
    @java.lang.Override()
    public int getOldListSize() {
        return 0;
    }
    
    @java.lang.Override()
    public int getNewListSize() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
    
    @java.lang.Override()
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return false;
    }
}