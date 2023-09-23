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
public final class SignUpFragment_MembersInjector implements MembersInjector<SignUpFragment> {
  private final Provider<NetworkRepository> repositoryProvider;

  public SignUpFragment_MembersInjector(Provider<NetworkRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<SignUpFragment> create(
      Provider<NetworkRepository> repositoryProvider) {
    return new SignUpFragment_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(SignUpFragment instance) {
    injectRepository(instance, repositoryProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.activities.SignUpFragment.repository")
  public static void injectRepository(SignUpFragment instance, NetworkRepository repository) {
    instance.repository = repository;
  }
}
