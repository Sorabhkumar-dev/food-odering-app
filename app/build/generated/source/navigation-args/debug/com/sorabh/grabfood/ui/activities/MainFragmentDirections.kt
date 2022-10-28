package com.sorabh.grabfood.ui.activities

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R

public class MainFragmentDirections private constructor() {
  public companion object {
    public fun actionMainFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_mainFragment_to_loginFragment)
  }
}
