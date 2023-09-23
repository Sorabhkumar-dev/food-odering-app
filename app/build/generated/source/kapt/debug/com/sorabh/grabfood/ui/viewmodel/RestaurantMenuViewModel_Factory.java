package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetRestaurantMenuUseCase;
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
public final class RestaurantMenuViewModel_Factory implements Factory<RestaurantMenuViewModel> {
  private final Provider<GetRestaurantMenuUseCase> getRestaurantMenuUseCaseProvider;

  private final Provider<LocalDBRepository> localDBRepositoryProvider;

  public RestaurantMenuViewModel_Factory(
      Provider<GetRestaurantMenuUseCase> getRestaurantMenuUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider) {
    this.getRestaurantMenuUseCaseProvider = getRestaurantMenuUseCaseProvider;
    this.localDBRepositoryProvider = localDBRepositoryProvider;
  }

  @Override
  public RestaurantMenuViewModel get() {
    return newInstance(getRestaurantMenuUseCaseProvider.get(), localDBRepositoryProvider.get());
  }

  public static RestaurantMenuViewModel_Factory create(
      Provider<GetRestaurantMenuUseCase> getRestaurantMenuUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider) {
    return new RestaurantMenuViewModel_Factory(getRestaurantMenuUseCaseProvider, localDBRepositoryProvider);
  }

  public static RestaurantMenuViewModel newInstance(
      GetRestaurantMenuUseCase getRestaurantMenuUseCase, LocalDBRepository localDBRepository) {
    return new RestaurantMenuViewModel(getRestaurantMenuUseCase, localDBRepository);
  }
}
