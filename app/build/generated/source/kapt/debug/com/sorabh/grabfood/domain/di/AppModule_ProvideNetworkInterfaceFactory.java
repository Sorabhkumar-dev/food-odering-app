package com.sorabh.grabfood.domain.di;

import com.sorabh.grabfood.domain.network_api.NetworkInterface;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideNetworkInterfaceFactory implements Factory<NetworkInterface> {
  private final AppModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public AppModule_ProvideNetworkInterfaceFactory(AppModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public NetworkInterface get() {
    return provideNetworkInterface(module, okHttpClientProvider.get());
  }

  public static AppModule_ProvideNetworkInterfaceFactory create(AppModule module,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new AppModule_ProvideNetworkInterfaceFactory(module, okHttpClientProvider);
  }

  public static NetworkInterface provideNetworkInterface(AppModule instance,
      OkHttpClient okHttpClient) {
    return Preconditions.checkNotNullFromProvides(instance.provideNetworkInterface(okHttpClient));
  }
}
