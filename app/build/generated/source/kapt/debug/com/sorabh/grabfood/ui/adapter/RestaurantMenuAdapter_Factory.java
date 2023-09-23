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
public final class RestaurantMenuAdapter_Factory implements Factory<RestaurantMenuAdapter> {
  @Override
  public RestaurantMenuAdapter get() {
    return newInstance();
  }

  public static RestaurantMenuAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RestaurantMenuAdapter newInstance() {
    return new RestaurantMenuAdapter();
  }

  private static final class InstanceHolder {
    private static final RestaurantMenuAdapter_Factory INSTANCE = new RestaurantMenuAdapter_Factory();
  }
}
