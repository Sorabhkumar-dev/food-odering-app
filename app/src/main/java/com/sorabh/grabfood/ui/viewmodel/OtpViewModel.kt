package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetOTPUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(private val getOTPUseCase: GetOTPUseCase) : ViewModel() {

    val userOTPFlow = MutableStateFlow("")

    val passwordFlow = MutableStateFlow("")

    val confirmPasswordFlow = MutableStateFlow("")

    fun onUserOTPChanged(otp: String) {
        userOTPFlow.value = otp
    }

    fun onPasswordChanged(password: String) {
        passwordFlow.value = password
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        confirmPasswordFlow.value = confirmPassword
    }

    fun setupApiCall(phone: String, onOTPGet: (Result<OTPResponse>) -> Unit) {
        if (userOTPFlow.value.isNotEmpty() && passwordFlow.value.isNotEmpty() && confirmPasswordFlow.value.isNotEmpty() && passwordFlow.value == confirmPasswordFlow.value) {
            val header = HashMap<String, String>().apply {
                this[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
                this[Keys.TOKEN] = Constants.MAIN_TOKEN
            }
            val params = JsonObject().apply {
                addProperty(Keys.MOBILE_NUMBER, phone)
                addProperty(Keys.PASSWORD, passwordFlow.value)
                addProperty(Keys.OTP, userOTPFlow.value)
            }
            getOtp(OderPostModel(header, params),onOTPGet)
        }
    }

    private fun getOtp(postModel: OderPostModel, onOTPGet: (Result<OTPResponse>) -> Unit) {
        viewModelScope.launch {
            getOTPUseCase(postModel).collect {
                onOTPGet(it)
            }
        }
    }
}