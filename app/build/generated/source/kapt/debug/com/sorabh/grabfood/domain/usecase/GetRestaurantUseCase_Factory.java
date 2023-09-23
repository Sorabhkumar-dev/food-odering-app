package com.sorabh.grabfood.domain.usecase;

import com.sorabh.grabfood.domain.repository.NetworkRepository;
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
public final class GetRestaurantUseCase_Factory implements Factory<GetRestaurantUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetRestaurantUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetRestaurantUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetRestaurantUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetRestaurantUseCase_Factory(networkRepositoryProvider);
  }

  public static GetRestaurantUseCase newInstance(NetworkRepository networkRepository) {
    return new GetRestaurantUseCase(networkRepository);
  }
}
