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
public final class OTPFragment_MembersInjector implements MembersInjector<OTPFragment> {
  private final Provider<NetworkRepository> repositoryProvider;

  public OTPFragment_MembersInjector(Provider<NetworkRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public static MembersInjector<OTPFragment> create(
      Provider<NetworkRepository> repositoryProvider) {
    return new OTPFragment_MembersInjector(repositoryProvider);
  }

  @Override
  public void injectMembers(OTPFragment instance) {
    injectRepository(instance, repositoryProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.activities.OTPFragment.repository")
  public static void injectRepository(OTPFragment instance, NetworkRepository repository) {
    instance.repository = repository;
  }
}
