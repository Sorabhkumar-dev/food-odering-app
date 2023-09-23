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
public final class GetForgotPasswordUseCase_Factory implements Factory<GetForgotPasswordUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetForgotPasswordUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetForgotPasswordUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetForgotPasswordUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetForgotPasswordUseCase_Factory(networkRepositoryProvider);
  }

  public static GetForgotPasswordUseCase newInstance(NetworkRepository networkRepository) {
    return new GetForgotPasswordUseCase(networkRepository);
  }
}
