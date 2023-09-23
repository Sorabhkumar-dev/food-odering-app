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
public final class GetOderConfirmationUseCase_Factory implements Factory<GetOderConfirmationUseCase> {
  private final Provider<NetworkRepository> networkRepositoryProvider;

  public GetOderConfirmationUseCase_Factory(Provider<NetworkRepository> networkRepositoryProvider) {
    this.networkRepositoryProvider = networkRepositoryProvider;
  }

  @Override
  public GetOderConfirmationUseCase get() {
    return newInstance(networkRepositoryProvider.get());
  }

  public static GetOderConfirmationUseCase_Factory create(
      Provider<NetworkRepository> networkRepositoryProvider) {
    return new GetOderConfirmationUseCase_Factory(networkRepositoryProvider);
  }

  public static GetOderConfirmationUseCase newInstance(NetworkRepository networkRepository) {
    return new GetOderConfirmationUseCase(networkRepository);
  }
}