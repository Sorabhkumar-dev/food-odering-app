package com.sorabh.grabfood.ui.adapter;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FoodItemAdapter_Factory implements Factory<FoodItemAdapter> {
  @Override
  public FoodItemAdapter get() {
    return newInstance();
  }

  public static FoodItemAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FoodItemAdapter newInstance() {
    return new FoodItemAdapter();
  }

  private static final class InstanceHolder {
    private static final FoodItemAdapter_Factory INSTANCE = new FoodItemAdapter_Factory();
  }
}
