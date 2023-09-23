package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase;
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
public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
  private final Provider<GetForgotPasswordUseCase> getForgotPasswordUseCaseProvider;

  public ForgotPasswordViewModel_Factory(
      Provider<GetForgotPasswordUseCase> getForgotPasswordUseCaseProvider) {
    this.getForgotPasswordUseCaseProvider = getForgotPasswordUseCaseProvider;
  }

  @Override
  public ForgotPasswordViewModel get() {
    return newInstance(getForgotPasswordUseCaseProvider.get());
  }

  public static ForgotPasswordViewModel_Factory create(
      Provider<GetForgotPasswordUseCase> getForgotPasswordUseCaseProvider) {
    return new ForgotPasswordViewModel_Factory(getForgotPasswordUseCaseProvider);
  }

  public static ForgotPasswordViewModel newInstance(
      GetForgotPasswordUseCase getForgotPasswordUseCase) {
    return new ForgotPasswordViewModel(getForgotPasswordUseCase);
  }
}
