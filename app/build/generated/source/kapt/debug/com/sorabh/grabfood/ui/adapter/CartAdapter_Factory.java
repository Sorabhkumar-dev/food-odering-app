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
public final class CartAdapter_Factory implements Factory<CartAdapter> {
  @Override
  public CartAdapter get() {
    return newInstance();
  }

  public static CartAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CartAdapter newInstance() {
    return new CartAdapter();
  }

  private static final class InstanceHolder {
    private static final CartAdapter_Factory INSTANCE = new CartAdapter_Factory();
  }
}
