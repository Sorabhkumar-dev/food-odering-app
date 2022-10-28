package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OTPFragmentArgs(
  public val phoneNo: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("phone_no", this.phoneNo)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("phone_no", this.phoneNo)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OTPFragmentArgs {
      bundle.setClassLoader(OTPFragmentArgs::class.java.classLoader)
      val __phoneNo : String?
      if (bundle.containsKey("phone_no")) {
        __phoneNo = bundle.getString("phone_no")
        if (__phoneNo == null) {
          throw IllegalArgumentException("Argument \"phone_no\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"phone_no\" is missing and does not have an android:defaultValue")
      }
      return OTPFragmentArgs(__phoneNo)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): OTPFragmentArgs {
      val __phoneNo : String?
      if (savedStateHandle.contains("phone_no")) {
        __phoneNo = savedStateHandle["phone_no"]
        if (__phoneNo == null) {
          throw IllegalArgumentException("Argument \"phone_no\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"phone_no\" is missing and does not have an android:defaultValue")
      }
      return OTPFragmentArgs(__phoneNo)
    }
  }
}
