package com.sorabh.grabfood.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.databinding.LoginFragmentBinding;
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse;
import com.sorabh.grabfood.domain.model.post.LoginPostModel;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006%"}, d2 = {"Lcom/sorabh/grabfood/ui/activities/LoginFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/LoginFragmentBinding;", "loginSharedPreferences", "Landroid/content/SharedPreferences;", "navController", "Landroidx/navigation/NavController;", "repository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "getRepository", "()Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "setRepository", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/LoginViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setOnClickListener", "", "setupLoginData", "loginData", "Lcom/sorabh/grabfood/domain/model/login_respones/LoginResponse;", "setupLoginRequest", "setupObserver", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class LoginFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.NetworkRepository repository;
    private androidx.navigation.NavController navController;
    private com.sorabh.grabfood.databinding.LoginFragmentBinding binding;
    private android.content.SharedPreferences loginSharedPreferences;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public LoginFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.NetworkRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.NetworkRepository p0) {
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.LoginViewModel getViewModel() {
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
    
    private final void startupInitializer(android.view.LayoutInflater inflater) {
    }
    
    private final void setOnClickListener() {
    }
    
    private final void setupLoginRequest() {
    }
    
    private final void setupObserver() {
    }
    
    private final void setupLoginData(com.sorabh.grabfood.domain.model.login_respones.LoginResponse loginData) {
    }
}