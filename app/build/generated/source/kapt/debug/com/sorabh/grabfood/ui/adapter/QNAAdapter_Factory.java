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
public final class QNAAdapter_Factory implements Factory<QNAAdapter> {
  @Override
  public QNAAdapter get() {
    return newInstance();
  }

  public static QNAAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static QNAAdapter newInstance() {
    return new QNAAdapter();
  }

  private static final class InstanceHolder {
    private static final QNAAdapter_Factory INSTANCE = new QNAAdapter_Factory();
  }
}
