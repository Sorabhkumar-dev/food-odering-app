// Generated by view binder compiler. Do not edit!
package com.sorabh.grabfood.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.sorabh.grabfood.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MainFragmentBinding implements ViewBinding {
  @NonNull
  private final DrawerLayout rootView;

  @NonNull
  public final CoordinatorLayout coordinatorLayout;

  @NonNull
  public final DrawerLayout drawerLayout;

  @NonNull
  public final FrameLayout frameLayout;

  @NonNull
  public final NavigationView navigationView;

  @NonNull
  public final MaterialToolbar toolBar;

  private MainFragmentBinding(@NonNull DrawerLayout rootView,
      @NonNull CoordinatorLayout coordinatorLayout, @NonNull DrawerLayout drawerLayout,
      @NonNull FrameLayout frameLayout, @NonNull NavigationView navigationView,
      @NonNull MaterialToolbar toolBar) {
    this.rootView = rootView;
    this.coordinatorLayout = coordinatorLayout;
    this.drawerLayout = drawerLayout;
    this.frameLayout = frameLayout;
    this.navigationView = navigationView;
    this.toolBar = toolBar;
  }

  @Override
  @NonNull
  public DrawerLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MainFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.main_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.coordinatorLayout;
      CoordinatorLayout coordinatorLayout = ViewBindings.findChildViewById(rootView, id);
      if (coordinatorLayout == null) {
        break missingId;
      }

      DrawerLayout drawerLayout = (DrawerLayout) rootView;

      id = R.id.frameLayout;
      FrameLayout frameLayout = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout == null) {
        break missingId;
      }

      id = R.id.navigationView;
      NavigationView navigationView = ViewBindings.findChildViewById(rootView, id);
      if (navigationView == null) {
        break missingId;
      }

      id = R.id.toolBar;
      MaterialToolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      return new MainFragmentBinding((DrawerLayout) rootView, coordinatorLayout, drawerLayout,
          frameLayout, navigationView, toolBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}