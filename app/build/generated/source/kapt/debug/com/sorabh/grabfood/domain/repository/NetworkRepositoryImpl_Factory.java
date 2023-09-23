package com.sorabh.grabfood.domain.repository;

import com.sorabh.grabfood.domain.network_api.NetworkInterface;
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
public final class NetworkRepositoryImpl_Factory implements Factory<NetworkRepositoryImpl> {
  private final Provider<NetworkInterface> networkInterfaceProvider;

  public NetworkRepositoryImpl_Factory(Provider<NetworkInterface> networkInterfaceProvider) {
    this.networkInterfaceProvider = networkInterfaceProvider;
  }

  @Override
  public NetworkRepositoryImpl get() {
    return newInstance(networkInterfaceProvider.get());
  }

  public static NetworkRepositoryImpl_Factory create(
      Provider<NetworkInterface> networkInterfaceProvider) {
    return new NetworkRepositoryImpl_Factory(networkInterfaceProvider);
  }

  public static NetworkRepositoryImpl newInstance(NetworkInterface networkInterface) {
    return new NetworkRepositoryImpl(networkInterface);
  }
}
