package com.sorabh.grabfood.ui.activities

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R

public class SignUpFragmentDirections private constructor() {
  public companion object {
    public fun actionSignUpFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_signUpFragment_to_loginFragment)
  }
}
