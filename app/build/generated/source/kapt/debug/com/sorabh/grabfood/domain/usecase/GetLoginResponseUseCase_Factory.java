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
public final class GetLoginResponseUseCase_Factory implements Factory<GetLoginResponseUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetLoginResponseUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetLoginResponseUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetLoginResponseUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetLoginResponseUseCase_Factory(networkRepositoryProvider);
  }

  public static GetLoginResponseUseCase newInstance(NetworkRepository networkRepository) {
    return new GetLoginResponseUseCase(networkRepository);
  }
}
