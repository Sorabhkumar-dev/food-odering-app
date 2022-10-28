package com.sorabh.grabfood.ui.fragments.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentOderHistoryBinding;
import com.sorabh.grabfood.domain.model.post.OderHistoryPost;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/history/OderHistoryFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentOderHistoryBinding;", "historyAdapter", "Lcom/sorabh/grabfood/ui/adapter/OrderHistoryAdapter;", "getHistoryAdapter", "()Lcom/sorabh/grabfood/ui/adapter/OrderHistoryAdapter;", "setHistoryAdapter", "(Lcom/sorabh/grabfood/ui/adapter/OrderHistoryAdapter;)V", "repository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "getRepository", "()Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "setRepository", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/OderHistoryVieModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/OderHistoryVieModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupApiCall", "", "setupObserver", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class OderHistoryFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.sorabh.grabfood.databinding.FragmentOderHistoryBinding binding;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.NetworkRepository repository;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter historyAdapter;
    
    public OderHistoryFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.NetworkRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter getHistoryAdapter() {
        return null;
    }
    
    public final void setHistoryAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitializer(android.view.LayoutInflater inflater) {
    }
    
    private final void setupApiCall() {
    }
    
    private final void setupObserver() {
    }
}