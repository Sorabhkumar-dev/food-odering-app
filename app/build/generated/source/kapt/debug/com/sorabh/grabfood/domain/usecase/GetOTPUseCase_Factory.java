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
public final class GetOTPUseCase_Factory implements Factory<GetOTPUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetOTPUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetOTPUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetOTPUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetOTPUseCase_Factory(networkRepositoryProvider);
  }

  public static GetOTPUseCase newInstance(NetworkRepository networkRepository) {
    return new GetOTPUseCase(networkRepository);
  }
}
