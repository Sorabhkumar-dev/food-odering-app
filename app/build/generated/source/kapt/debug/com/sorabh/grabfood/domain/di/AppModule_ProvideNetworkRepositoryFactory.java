package com.sorabh.grabfood.domain.di;

import com.sorabh.grabfood.domain.repository.NetworkRepository;
import com.sorabh.grabfood.domain.repository.NetworkRepositoryImpl;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideNetworkRepositoryFactory implements Factory<NetworkRepository> {
  private final AppModule module;

  private final Provider<NetworkRepositoryImpl> networkRepositoryImplProvider;

  public AppModule_ProvideNetworkRepositoryFactory(AppModule module,
      Provider<NetworkRepositoryImpl> networkRepositoryImplProvider) {
    this.module = module;
    this.networkRepositoryImplProvider = networkRepositoryImplProvider;
  }

  @Override
  public NetworkRepository get() {
    return provideNetworkRepository(module, networkRepositoryImplProvider.get());
  }

  public static AppModule_ProvideNetworkRepositoryFactory create(AppModule module,
      Provider<NetworkRepositoryImpl> networkRepositoryImplProvider) {
    return new AppModule_ProvideNetworkRepositoryFactory(module, networkRepositoryImplProvider);
  }

  public static NetworkRepository provideNetworkRepository(AppModule instance,
      NetworkRepositoryImpl networkRepositoryImpl) {
    return Preconditions.checkNotNullFromProvides(instance.provideNetworkRepository(networkRepositoryImpl));
  }
}
