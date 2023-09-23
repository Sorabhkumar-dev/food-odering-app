package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetRestaurantUseCase;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetRestaurantUseCase> getRestaurantUseCaseProvider;

  private final Provider<LocalDBRepository> localDBRepositoryProvider;

  public HomeViewModel_Factory(Provider<GetRestaurantUseCase> getRestaurantUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider) {
    this.getRestaurantUseCaseProvider = getRestaurantUseCaseProvider;
    this.localDBRepositoryProvider = localDBRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getRestaurantUseCaseProvider.get(), localDBRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetRestaurantUseCase> getRestaurantUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider) {
    return new HomeViewModel_Factory(getRestaurantUseCaseProvider, localDBRepositoryProvider);
  }

  public static HomeViewModel newInstance(GetRestaurantUseCase getRestaurantUseCase,
      LocalDBRepository localDBRepository) {
    return new HomeViewModel(getRestaurantUseCase, localDBRepository);
  }
}
