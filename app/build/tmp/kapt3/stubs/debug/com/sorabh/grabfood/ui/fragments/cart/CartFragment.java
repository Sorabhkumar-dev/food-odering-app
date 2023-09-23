package com.sorabh.grabfood.ui.fragments.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
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
import com.sorabh.grabfood.ui.adapter.CartAdapter;
import com.sorabh.grabfood.ui.adapter.CartViewHolder;
import com.sorabh.grabfood.ui.viewmodel.CartViewModel;
import com.sorabh.grabfood.util.Constants;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/sorabh/grabfood/ui/fragments/cart/CartFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/FragmentCartBinding;", "cartAdapter", "Lcom/sorabh/grabfood/ui/adapter/CartAdapter;", "getCartAdapter", "()Lcom/sorabh/grabfood/ui/adapter/CartAdapter;", "setCartAdapter", "(Lcom/sorabh/grabfood/ui/adapter/CartAdapter;)V", "localMenu", "Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;", "viewModel", "Lcom/sorabh/grabfood/ui/viewmodel/CartViewModel;", "getViewModel", "()Lcom/sorabh/grabfood/ui/viewmodel/CartViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "placeOrder", "", "menu", "(Lcom/sorabh/grabfood/domain/model/restaurant_menu_response/Menu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showBottomSheet", "isConfirm", "", "startupInitialization", "updateMenuList", "app_debug"})
public final class CartFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.sorabh.grabfood.databinding.FragmentCartBinding binding;
    @javax.inject.Inject
    public com.sorabh.grabfood.ui.adapter.CartAdapter cartAdapter;
    @org.jetbrains.annotations.Nullable
    private com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu localMenu;
    
    public CartFragment() {
        super();
    }
    
    private final com.sorabh.grabfood.ui.viewmodel.CartViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.sorabh.grabfood.ui.adapter.CartAdapter getCartAdapter() {
        return null;
    }
    
    public final void setCartAdapter(@org.jetbrains.annotations.NotNull
    com.sorabh.grabfood.ui.adapter.CartAdapter p0) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void startupInitialization(android.view.LayoutInflater inflater) {
    }
    
    private final void updateMenuList() {
    }
    
    private final java.lang.Object placeOrder(com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void showBottomSheet(boolean isConfirm) {
    }
}