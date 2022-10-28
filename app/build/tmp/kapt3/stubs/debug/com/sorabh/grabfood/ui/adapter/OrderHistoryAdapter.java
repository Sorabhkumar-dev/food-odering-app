package com.sorabh.grabfood.ui.adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.databinding.OderHistotoyCardviewBinding;
import com.sorabh.grabfood.domain.model.oder_history_response.Bill;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0017J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/OrderHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/OrderHistoryViewHolder;", "foodItemAdapter", "Lcom/sorabh/grabfood/ui/adapter/FoodItemAdapter;", "(Lcom/sorabh/grabfood/ui/adapter/FoodItemAdapter;)V", "oderHistoryList", "", "Lcom/sorabh/grabfood/domain/model/oder_history_response/Bill;", "getDate", "", "str", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateOderHistoryList", "list", "", "app_debug"})
public final class OrderHistoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.OrderHistoryViewHolder> {
    private final com.sorabh.grabfood.ui.adapter.FoodItemAdapter foodItemAdapter = null;
    private java.util.List<com.sorabh.grabfood.domain.model.oder_history_response.Bill> oderHistoryList;
    
    @javax.inject.Inject()
    public OrderHistoryAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.FoodItemAdapter foodItemAdapter) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sorabh.grabfood.ui.adapter.OrderHistoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.OrderHistoryViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateOderHistoryList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sorabh.grabfood.domain.model.oder_history_response.Bill> list) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    private final java.lang.String getDate(java.lang.String str) {
        return null;
    }
}