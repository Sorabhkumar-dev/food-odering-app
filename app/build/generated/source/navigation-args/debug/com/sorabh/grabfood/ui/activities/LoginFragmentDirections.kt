package com.sorabh.grabfood.ui.activities

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToSignUpFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_signUpFragment)

    public fun actionLoginFragmentToForgotPasswordFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_forgotPasswordFragment)

    public fun actionLoginFragmentToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_mainFragment)
  }
}
