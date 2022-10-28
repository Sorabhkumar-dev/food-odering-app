package com.sorabh.grabfood.ui.activities

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_loginFragment)
  }
}
