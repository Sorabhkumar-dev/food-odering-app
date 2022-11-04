// Generated by Dagger (https://dagger.dev).
package com.sorabh.grabfood.ui.adapter;

import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RestaurantHomeAdapter_Factory implements Factory<RestaurantHomeAdapter> {
  private final Provider<LocalDBRepository> localDBRepositoryProvider;

  public RestaurantHomeAdapter_Factory(Provider<LocalDBRepository> localDBRepositoryProvider) {
    this.localDBRepositoryProvider = localDBRepositoryProvider;
  }

  @Override
  public RestaurantHomeAdapter get() {
    return newInstance(localDBRepositoryProvider.get());
  }

  public static RestaurantHomeAdapter_Factory create(
      Provider<LocalDBRepository> localDBRepositoryProvider) {
    return new RestaurantHomeAdapter_Factory(localDBRepositoryProvider);
  }

  public static RestaurantHomeAdapter newInstance(LocalDBRepository localDBRepository) {
    return new RestaurantHomeAdapter(localDBRepository);
  }
}