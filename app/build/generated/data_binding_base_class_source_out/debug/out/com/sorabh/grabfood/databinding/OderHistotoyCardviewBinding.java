// Generated by data binding compiler. Do not edit!
package com.sorabh.grabfood.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textview.MaterialTextView;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.domain.model.oder_history_response.Bill;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class OderHistotoyCardviewBinding extends ViewDataBinding {
  @NonNull
  public final MaterialTextView orderHistoryOderDate;

  @NonNull
  public final MaterialTextView orderHistoryOderPrice;

  @NonNull
  public final RecyclerView orderHistoryRecyclerView;

  @NonNull
  public final MaterialTextView orderHistoryRestaurantName;

  @Bindable
  protected Bill mDataX;

  protected OderHistotoyCardviewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      MaterialTextView orderHistoryOderDate, MaterialTextView orderHistoryOderPrice,
      RecyclerView orderHistoryRecyclerView, MaterialTextView orderHistoryRestaurantName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.orderHistoryOderDate = orderHistoryOderDate;
    this.orderHistoryOderPrice = orderHistoryOderPrice;
    this.orderHistoryRecyclerView = orderHistoryRecyclerView;
    this.orderHistoryRestaurantName = orderHistoryRestaurantName;
  }

  public abstract void setDataX(@Nullable Bill dataX);

  @Nullable
  public Bill getDataX() {
    return mDataX;
  }

  @NonNull
  public static OderHistotoyCardviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.oder_histotoy_cardview, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static OderHistotoyCardviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<OderHistotoyCardviewBinding>inflateInternal(inflater, R.layout.oder_histotoy_cardview, root, attachToRoot, component);
  }

  @NonNull
  public static OderHistotoyCardviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.oder_histotoy_cardview, null, false, component)
   */
  @NonNull
  @Deprecated
  public static OderHistotoyCardviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<OderHistotoyCardviewBinding>inflateInternal(inflater, R.layout.oder_histotoy_cardview, null, false, component);
  }

  public static OderHistotoyCardviewBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static OderHistotoyCardviewBinding bind(@NonNull View view, @Nullable Object component) {
    return (OderHistotoyCardviewBinding)bind(component, view, R.layout.oder_histotoy_cardview);
  }
}