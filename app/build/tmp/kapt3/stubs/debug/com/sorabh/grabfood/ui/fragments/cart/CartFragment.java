package com.sorabh.grabfood.ui.fragments.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.FragmentCartBinding;
import com.sorabh.grabfood.databinding.OderBottomSheetBinding;
import com.sorabh.grabfood.domain.model.post.OderPostModel;
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu;
import com.sorabh.grabfood.domain.network_api.Result;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.adapter.CartAdapter;
import com.sorabh.grabfood.ui.adapter.CartViewHolder;
import com.sorabh.grabfood.ui.viewmodel.CartViewModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010/\u001a\u00020(H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/cart/CartFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentCartBinding;", "cartAdapter", "Lcom/sorabh/grabfood/ui/adapter/CartAdapter;", "getCartAdapter", "()Lcom/sorabh/grabfood/ui/adapter/CartAdapter;", "setCartAdapter", "(Lcom/sorabh/grabfood/ui/adapter/CartAdapter;)V", "localDBRepository", "Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "getLocalDBRepository", "()Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;", "setLocalDBRepository", "(Lcom/sorabh/grabfood/domain/repository/LocalDBRepository;)V", "localMenu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "repository", "Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "getRepository", "()Lcom/sorabh/grabfood/domain/repository/NetworkRepository;", "setRepository", "(Lcom/sorabh/grabfood/domain/repository/NetworkRepository;)V", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/CartViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/CartViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "placeOrder", "", "menu", "setupObserver", "showBottomSheet", "isConfirm", "", "startupInitialization", "updateMenuList", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class CartFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.sorabh.grabfood.databinding.FragmentCartBinding binding;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.NetworkRepository repository;
    @javax.inject.Inject()
    public com.sorabh.grabfood.ui.adapter.CartAdapter cartAdapter;
    @javax.inject.Inject()
    public com.sorabh.grabfood.domain.repository.LocalDBRepository localDBRepository;
    private com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu localMenu;
    
    public CartFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.CartViewModel getViewModel() {
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
    public final com.sorabh.grabfood.ui.adapter.CartAdapter getCartAdapter() {
        return null;
    }
    
    public final void setCartAdapter(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.ui.adapter.CartAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.sorabh.grabfood.domain.repository.LocalDBRepository getLocalDBRepository() {
        return null;
    }
    
    public final void setLocalDBRepository(@org.jetbrains.annotations.NotNull()
    com.sorabh.grabfood.domain.repository.LocalDBRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitialization(android.view.LayoutInflater inflater) {
    }
    
    private final void updateMenuList() {
    }
    
    private final void placeOrder(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu) {
    }
    
    private final void setupObserver() {
    }
    
    private final void showBottomSheet(boolean isConfirm) {
    }
}