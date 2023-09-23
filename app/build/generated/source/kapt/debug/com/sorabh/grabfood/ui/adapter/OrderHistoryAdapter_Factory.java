package com.sorabh.grabfood.ui.adapter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OrderHistoryAdapter_Factory implements Factory<OrderHistoryAdapter> {
  private final Provider<FoodItemAdapter> foodItemAdapterProvider;

  public OrderHistoryAdapter_Factory(Provider<FoodItemAdapter> foodItemAdapterProvider) {
    this.foodItemAdapterProvider = foodItemAdapterProvider;
  }

  @Override
  public OrderHistoryAdapter get() {
    return newInstance(foodItemAdapterProvider.get());
  }

  public static OrderHistoryAdapter_Factory create(
      Provider<FoodItemAdapter> foodItemAdapterProvider) {
    return new OrderHistoryAdapter_Factory(foodItemAdapterProvider);
  }

  public static OrderHistoryAdapter newInstance(FoodItemAdapter foodItemAdapter) {
    return new OrderHistoryAdapter(foodItemAdapter);
  }
}
