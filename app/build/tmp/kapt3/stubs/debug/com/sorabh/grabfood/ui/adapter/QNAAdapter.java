package com.sorabh.grabfood.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.QNACardViewBinding;
import com.sorabh.grabfood.util.QNAData;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H\u0007R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/QNAAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sorabh/grabfood/ui/adapter/QNAAdapter$QNAViewHolder;", "()V", "qnaList", "", "Lcom/sorabh/grabfood/util/QNAData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "list", "", "QNAViewHolder", "app_debug"})
public final class QNAAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sorabh.grabfood.ui.adapter.QNAAdapter.QNAViewHolder> {
    private java.util.List<com.sorabh.grabfood.util.QNAData> qnaList;
    
    @javax.inject.Inject()
    public QNAAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sorabh.grabfood.ui.adapter.QNAAdapter.QNAViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.QNAAdapter.QNAViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void updateList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.sorabh.grabfood.util.QNAData> list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/sorabh/grabfood/ui/adapter/QNAAdapter$QNAViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "qnaCardViewBinding", "Lcom/sorabh/grabfood/databinding/QNACardViewBinding;", "(Lcom/sorabh/grabfood/ui/adapter/QNAAdapter;Lcom/sorabh/grabfood/databinding/QNACardViewBinding;)V", "getQnaCardViewBinding", "()Lcom/sorabh/grabfood/databinding/QNACardViewBinding;", "app_debug"})
    public final class QNAViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.sorabh.grabfood.databinding.QNACardViewBinding qnaCardViewBinding = null;
        
        public QNAViewHolder(@org.jetbrains.annotations.NotNull()
        com.sorabh.grabfood.databinding.QNACardViewBinding qnaCardViewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.sorabh.grabfood.databinding.QNACardViewBinding getQnaCardViewBinding() {
            return null;
        }
    }
}