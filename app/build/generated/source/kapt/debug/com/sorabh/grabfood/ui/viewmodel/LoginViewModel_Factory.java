package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase;
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
public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
  private final Provider<GetLoginResponseUseCase> getLoginResponseUseCaseProvider;

  private final Provider<PreferenceData> preferenceDataStoreProvider;

  public LoginViewModel_Factory(Provider<GetLoginResponseUseCase> getLoginResponseUseCaseProvider,
      Provider<PreferenceData> preferenceDataStoreProvider) {
    this.getLoginResponseUseCaseProvider = getLoginResponseUseCaseProvider;
    this.preferenceDataStoreProvider = preferenceDataStoreProvider;
  }

  @Override
  public LoginViewModel get() {
    return newInstance(getLoginResponseUseCaseProvider.get(), preferenceDataStoreProvider.get());
  }

  public static LoginViewModel_Factory create(
      Provider<GetLoginResponseUseCase> getLoginResponseUseCaseProvider,
      Provider<PreferenceData> preferenceDataStoreProvider) {
    return new LoginViewModel_Factory(getLoginResponseUseCaseProvider, preferenceDataStoreProvider);
  }

  public static LoginViewModel newInstance(GetLoginResponseUseCase getLoginResponseUseCase,
      PreferenceData preferenceDataStore) {
    return new LoginViewModel(getLoginResponseUseCase, preferenceDataStore);
  }
}
