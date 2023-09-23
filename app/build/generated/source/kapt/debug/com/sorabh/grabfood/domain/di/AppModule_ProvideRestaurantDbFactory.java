package com.sorabh.grabfood.domain.di;

import android.content.Context;
import com.sorabh.grabfood.domain.database.RestaurantDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideRestaurantDbFactory implements Factory<RestaurantDatabase> {
  private final AppModule module;

  private final Provider<Context> contextProvider;

  public AppModule_ProvideRestaurantDbFactory(AppModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public RestaurantDatabase get() {
    return provideRestaurantDb(module, contextProvider.get());
  }

  public static AppModule_ProvideRestaurantDbFactory create(AppModule module,
      Provider<Context> contextProvider) {
    return new AppModule_ProvideRestaurantDbFactory(module, contextProvider);
  }

  public static RestaurantDatabase provideRestaurantDb(AppModule instance, Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideRestaurantDb(context));
  }
}
