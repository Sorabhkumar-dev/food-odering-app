package com.sorabh.grabfood.ui.fragments.history;

import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.ui.adapter.OrderHistoryAdapter;
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
public final class OderHistoryFragment_MembersInjector implements MembersInjector<OderHistoryFragment> {
  private final Provider<NetworkRepository> repositoryProvider;

  private final Provider<OrderHistoryAdapter> historyAdapterProvider;

  public OderHistoryFragment_MembersInjector(Provider<NetworkRepository> repositoryProvider,
      Provider<OrderHistoryAdapter> historyAdapterProvider) {
    this.repositoryProvider = repositoryProvider;
    this.historyAdapterProvider = historyAdapterProvider;
  }

  public static MembersInjector<OderHistoryFragment> create(
      Provider<NetworkRepository> repositoryProvider,
      Provider<OrderHistoryAdapter> historyAdapterProvider) {
    return new OderHistoryFragment_MembersInjector(repositoryProvider, historyAdapterProvider);
  }

  @Override
  public void injectMembers(OderHistoryFragment instance) {
    injectRepository(instance, repositoryProvider.get());
    injectHistoryAdapter(instance, historyAdapterProvider.get());
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment.repository")
  public static void injectRepository(OderHistoryFragment instance, NetworkRepository repository) {
    instance.repository = repository;
  }

  @InjectedFieldSignature("com.sorabh.grabfood.ui.fragments.history.OderHistoryFragment.historyAdapter")
  public static void injectHistoryAdapter(OderHistoryFragment instance,
      OrderHistoryAdapter historyAdapter) {
    instance.historyAdapter = historyAdapter;
  }
}
