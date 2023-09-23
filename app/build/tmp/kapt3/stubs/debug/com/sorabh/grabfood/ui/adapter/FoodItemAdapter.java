package com.sorabh.grabfood.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem;
import com.sorabh.grabfood.databinding.FoodItemCardViewBinding;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/FoodItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/FoodItemViewHolder;", "()V", "foodItemList", "", "Lcom/sorabh/grabfood/api_response_classes/oder_history_response/FoodItem;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateFoodItem", "newFoodItem", "", "app_debug"})
public final class FoodItemAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.FoodItemViewHolder> {
    @org.jetbrains.annotations.NotNull
    private java.util.List<com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem> foodItemList;
    
    @javax.inject.Inject
    public FoodItemAdapter() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.sorabh.grabfood.ui.adapter.FoodItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.FoodItemViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateFoodItem(@org.jetbrains.annotations.NotNull
    java.util.List<com.sorabh.grabfood.api_response_classes.oder_history_response.FoodItem> newFoodItem) {
    }
}