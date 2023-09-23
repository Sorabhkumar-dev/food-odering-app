package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.datastore.PreferenceData;
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase;
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
public final class OderHistoryVieModel_Factory implements Factory<OderHistoryVieModel> {
  private final Provider<GetOderHistoryUseCase> getOderHistoryUseCaseProvider;

  private final Provider<PreferenceData> preferenceDataProvider;

  public OderHistoryVieModel_Factory(Provider<GetOderHistoryUseCase> getOderHistoryUseCaseProvider,
      Provider<PreferenceData> preferenceDataProvider) {
    this.getOderHistoryUseCaseProvider = getOderHistoryUseCaseProvider;
    this.preferenceDataProvider = preferenceDataProvider;
  }

  @Override
  public OderHistoryVieModel get() {
    return newInstance(getOderHistoryUseCaseProvider.get(), preferenceDataProvider.get());
  }

  public static OderHistoryVieModel_Factory create(
      Provider<GetOderHistoryUseCase> getOderHistoryUseCaseProvider,
      Provider<PreferenceData> preferenceDataProvider) {
    return new OderHistoryVieModel_Factory(getOderHistoryUseCaseProvider, preferenceDataProvider);
  }

  public static OderHistoryVieModel newInstance(GetOderHistoryUseCase getOderHistoryUseCase,
      PreferenceData preferenceData) {
    return new OderHistoryVieModel(getOderHistoryUseCase, preferenceData);
  }
}
