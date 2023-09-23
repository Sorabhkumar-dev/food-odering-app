package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.repository.LocalDBRepository;
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase;
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
public final class CartViewModel_Factory implements Factory<CartViewModel> {
  private final Provider<GetOderConfirmationUseCase> getOderConfirmationUseCaseProvider;

  private final Provider<LocalDBRepository> localDBRepositoryProvider;

  private final Provider<PreferenceData> preferenceDataProvider;

  public CartViewModel_Factory(
      Provider<GetOderConfirmationUseCase> getOderConfirmationUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider,
      Provider<PreferenceData> preferenceDataProvider) {
    this.getOderConfirmationUseCaseProvider = getOderConfirmationUseCaseProvider;
    this.localDBRepositoryProvider = localDBRepositoryProvider;
    this.preferenceDataProvider = preferenceDataProvider;
  }

  @Override
  public CartViewModel get() {
    return newInstance(getOderConfirmationUseCaseProvider.get(), localDBRepositoryProvider.get(), preferenceDataProvider.get());
  }

  public static CartViewModel_Factory create(
      Provider<GetOderConfirmationUseCase> getOderConfirmationUseCaseProvider,
      Provider<LocalDBRepository> localDBRepositoryProvider,
      Provider<PreferenceData> preferenceDataProvider) {
    return new CartViewModel_Factory(getOderConfirmationUseCaseProvider, localDBRepositoryProvider, preferenceDataProvider);
  }

  public static CartViewModel newInstance(GetOderConfirmationUseCase getOderConfirmationUseCase,
      LocalDBRepository localDBRepository, PreferenceData preferenceData) {
    return new CartViewModel(getOderConfirmationUseCase, localDBRepository, preferenceData);
  }
}
