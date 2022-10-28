// Generated by view binder compiler. Do not edit!
package com.sorabh.grabfood.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.sorabh.grabfood.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRestaurantMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton btnProceed;

  @NonNull
  public final ProgressBar restaurantMenuProgressBar;

  @NonNull
  public final RecyclerView restaurantMenuRecyclerView;

  private FragmentRestaurantMenuBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton btnProceed, @NonNull ProgressBar restaurantMenuProgressBar,
      @NonNull RecyclerView restaurantMenuRecyclerView) {
    this.rootView = rootView;
    this.btnProceed = btnProceed;
    this.restaurantMenuProgressBar = restaurantMenuProgressBar;
    this.restaurantMenuRecyclerView = restaurantMenuRecyclerView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRestaurantMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRestaurantMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_restaurant_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRestaurantMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_proceed;
      MaterialButton btnProceed = ViewBindings.findChildViewById(rootView, id);
      if (btnProceed == null) {
        break missingId;
      }

      id = R.id.restaurant_menu_progressBar;
      ProgressBar restaurantMenuProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (restaurantMenuProgressBar == null) {
        break missingId;
      }

      id = R.id.restaurant_menu_recyclerView;
      RecyclerView restaurantMenuRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (restaurantMenuRecyclerView == null) {
        break missingId;
      }

      return new FragmentRestaurantMenuBinding((ConstraintLayout) rootView, btnProceed,
          restaurantMenuProgressBar, restaurantMenuRecyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
