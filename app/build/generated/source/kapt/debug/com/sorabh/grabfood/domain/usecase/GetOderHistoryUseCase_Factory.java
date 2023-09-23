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
public final class GetOderHistoryUseCase_Factory implements Factory<GetOderHistoryUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetOderHistoryUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetOderHistoryUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetOderHistoryUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetOderHistoryUseCase_Factory(networkRepositoryProvider);
  }

  public static GetOderHistoryUseCase newInstance(NetworkRepository networkRepository) {
    return new GetOderHistoryUseCase(networkRepository);
  }
}
