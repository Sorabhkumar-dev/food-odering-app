package com.sorabh.grabfood.domain.di;

import com.sorabh.grabfood.domain.database.LocalDAO;
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
public final class AppModule_ProvideDaoFactory implements Factory<LocalDAO> {
  private final AppModule module;

  private final Provider<RestaurantDatabase> dbProvider;

  public AppModule_ProvideDaoFactory(AppModule module, Provider<RestaurantDatabase> dbProvider) {
    this.module = module;
    this.dbProvider = dbProvider;
  }

  @Override
  public LocalDAO get() {
    return provideDao(module, dbProvider.get());
  }

  public static AppModule_ProvideDaoFactory create(AppModule module,
      Provider<RestaurantDatabase> dbProvider) {
    return new AppModule_ProvideDaoFactory(module, dbProvider);
  }

  public static LocalDAO provideDao(AppModule instance, RestaurantDatabase db) {
    return Preconditions.checkNotNullFromProvides(instance.provideDao(db));
  }
}