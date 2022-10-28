package com.sorabh.grabfood.ui.activities

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R

public class OTPFragmentDirections private constructor() {
  public companion object {
    public fun actionOTPFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_OTPFragment_to_loginFragment)
  }
}
