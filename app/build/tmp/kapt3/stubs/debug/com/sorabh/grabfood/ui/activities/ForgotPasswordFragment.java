package com.sorabh.grabfood.ui.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.ForgotPasswordFragmentBinding;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/sorabh/grabfood/ui/activities/ForgotPasswordFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/ForgotPasswordFragmentBinding;", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/ForgotPasswordViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/ForgotPasswordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setOnClickListener", "", "setupApiCall", "phone", "", "email", "setupObserver", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class ForgotPasswordFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.sorabh.grabfood.databinding.ForgotPasswordFragmentBinding binding;
    private androidx.navigation.NavController navController;
    
    public ForgotPasswordFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitializer() {
    }
    
    private final void setOnClickListener() {
    }
    
    private final void setupApiCall(java.lang.String phone, java.lang.String email) {
    }
    
    private final void setupObserver() {
    }
}