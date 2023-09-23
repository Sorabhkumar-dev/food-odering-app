package com.sorabh.grabfood.domain.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideContextFactory implements Factory<Context> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideContextFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Context get() {
    return provideContext(module, contextProvider.get());
  }

  public static AppModule_ProvideContextFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideContextFactory(module, contextProvider);
  }

  public static Context provideContext(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideContext(context));
  }
}
