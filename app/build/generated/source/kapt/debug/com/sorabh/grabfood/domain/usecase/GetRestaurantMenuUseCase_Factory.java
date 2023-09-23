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
public final class GetRestaurantMenuUseCase_Factory implements Factory<GetRestaurantMenuUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetRestaurantMenuUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetRestaurantMenuUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetRestaurantMenuUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetRestaurantMenuUseCase_Factory(networkRepositoryProvider);
  }

  public static GetRestaurantMenuUseCase newInstance(NetworkRepository networkRepository) {
    return new GetRestaurantMenuUseCase(networkRepository);
  }
}
