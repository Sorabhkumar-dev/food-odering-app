package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import androidx.navigation.NavDirections
import com.sorabh.grabfood.R
import kotlin.Int
import kotlin.String

public class ForgotPasswordFragmentDirections private constructor() {
  private data class ActionForgotPasswordFragmentToOTPFragment(
    public val phoneNo: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_forgotPasswordFragment_to_OTPFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("phone_no", this.phoneNo)
        return result
      }
  }

  public companion object {
    public fun actionForgotPasswordFragmentToOTPFragment(phoneNo: String): NavDirections =
        ActionForgotPasswordFragmentToOTPFragment(phoneNo)
  }
}
