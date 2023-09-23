package com.sorabh.grabfood.ui.viewmodel;

import com.sorabh.grabfood.domain.usecase.GetSignupUseCase;
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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<GetSignupUseCase> getSignupUseCaseProvider;

  public SignUpViewModel_Factory(Provider<GetSignupUseCase> getSignupUseCaseProvider) {
    this.getSignupUseCaseProvider = getSignupUseCaseProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(getSignupUseCaseProvider.get());
  }

  public static SignUpViewModel_Factory create(
      Provider<GetSignupUseCase> getSignupUseCaseProvider) {
    return new SignUpViewModel_Factory(getSignupUseCaseProvider);
  }

  public static SignUpViewModel newInstance(GetSignupUseCase getSignupUseCase) {
    return new SignUpViewModel(getSignupUseCase);
  }
}
