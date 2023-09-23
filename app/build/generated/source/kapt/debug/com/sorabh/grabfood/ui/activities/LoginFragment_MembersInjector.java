package com.sorabh.grabfood.ui.activities;

import com.sorabh.grabfood.domain.repository.NetworkRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<NetworkRepository> repositoryProvider;

  public LoginFragment_MembersInjector(Provider<NetworkRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<NetworkRepository> repositoryProvider) {
    return new LoginFragment_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    injectRepository(instance, repositoryProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.activities.LoginFragment.repository")
  public static void injectRepository(LoginFragment instance, NetworkRepository repository) {
    instance.repository = repository;
  }
}
