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
public final class RestaurantHomeAdapter_Factory implements Factory<RestaurantHomeAdapter> {
  @Override
  public RestaurantHomeAdapter get() {
    return newInstance();
  }

  public static RestaurantHomeAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RestaurantHomeAdapter newInstance() {
    return new RestaurantHomeAdapter();
  }

  private static final class InstanceHolder {
    private static final RestaurantHomeAdapter_Factory INSTANCE = new RestaurantHomeAdapter_Factory();
  }
}
