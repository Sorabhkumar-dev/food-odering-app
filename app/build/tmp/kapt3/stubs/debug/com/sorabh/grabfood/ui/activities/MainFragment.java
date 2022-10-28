package com.sorabh.grabfood.ui.activities;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.databinding.MainFragmentBinding;
import com.sorabh.grabfood.ui.fragments.cart.CartFragment;
import com.sorabh.grabfood.ui.fragments.favorites.FavoriteRestaurantsFragment;
import com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment;
import com.sorabh.grabfood.ui.fragments.home.BaseFragment;
import com.sorabh.grabfood.ui.fragments.home.HomeFragment;
import com.sorabh.grabfood.ui.fragments.profile.MyProfileFragment;
import com.sorabh.grabfood.ui.fragments.qna.QNAFragment;
import com.sorabh.grabfood.util.Keys;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/sorabh/grabfood/ui/activities/MainFragment;", "Lcom/sorabh/grabfood/ui/fragments/home/BaseFragment;", "()V", "binding", "Lcom/sorabh/grabfood/databinding/MainFragmentBinding;", "headerView", "Landroid/view/View;", "navController", "Landroidx/navigation/NavController;", "sharedPreferences", "Landroid/content/SharedPreferences;", "changeFragmentAndTitle", "", "fragment", "Landroidx/fragment/app/Fragment;", "title", "", "confirmLogOutDialog", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupDrawerLayout", "setupHeaderLayout", "setupNavigationItemSelector", "startupInitializer", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainFragment extends com.sorabh.grabfood.ui.fragments.home.BaseFragment {
    private android.view.View headerView;
    private com.sorabh.grabfood.databinding.MainFragmentBinding binding;
    private androidx.navigation.NavController navController;
    private android.content.SharedPreferences sharedPreferences;
    
    public MainFragment() {
        super();
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
    
    private final void setupDrawerLayout() {
    }
    
    private final void setupHeaderLayout() {
    }
    
    private final void setupNavigationItemSelector() {
    }
    
    private final void changeFragmentAndTitle(androidx.fragment.app.Fragment fragment, java.lang.String title) {
    }
    
    private final void confirmLogOutDialog() {
    }
}