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
public final class GetSignupUseCase_Factory implements Factory<GetSignupUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetSignupUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetSignupUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetSignupUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetSignupUseCase_Factory(networkRepositoryProvider);
  }

  public static GetSignupUseCase newInstance(NetworkRepository networkRepository) {
    return new GetSignupUseCase(networkRepository);
  }
}
