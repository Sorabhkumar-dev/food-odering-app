// Generated by Dagger (https://dagger.dev).
package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.usecase.GetOTPUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class OtpViewModel_Factory implements Factory<OtpViewModel> {
  private final Provider<GetOTPUseCase> getOTPUseCaseProvider;

  public OtpViewModel_Factory(Provider<GetOTPUseCase> getOTPUseCaseProvider) {
    this.getOTPUseCaseProvider = getOTPUseCaseProvider;
  }

  @Override
  public OtpViewModel get() {
    return newInstance(getOTPUseCaseProvider.get());
  }

  public static OtpViewModel_Factory create(Provider<GetOTPUseCase> getOTPUseCaseProvider) {
    return new OtpViewModel_Factory(getOTPUseCaseProvider);
  }

  public static OtpViewModel newInstance(GetOTPUseCase getOTPUseCase) {
    return new OtpViewModel(getOTPUseCase);
  }
}