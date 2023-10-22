package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetSignupUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val getSignupUseCase: GetSignupUseCase) :
    ViewModel() {
    val deliveryAddressFlow = MutableStateFlow("")
    val userMobileFlow = MutableStateFlow("")
    val userEmailFlow = MutableStateFlow("")
    val userNameFlow = MutableStateFlow("")

    val confirmPasswordFlow = MutableStateFlow("")
    val passwordFlow = MutableStateFlow("")

    val passwordVisible = MutableStateFlow(false)
    val confirmPasswordVisible = MutableStateFlow(false)


    private val _signUpFlow: MutableStateFlow<Result<SignUpResponse>> =
        MutableStateFlow(Result.Loading())
    val signUpFlow = _signUpFlow.asStateFlow()

    fun onUserNameChanged(name: String) {
        viewModelScope.launch {
            userNameFlow.value = name
        }
    }

    fun onMobileChanged(mobile: String) {
        viewModelScope.launch {
            userMobileFlow.value = mobile
        }
    }

    fun onEmailChanged(email: String) {
        viewModelScope.launch {
            userEmailFlow.value = email
        }
    }

    fun onAddressChanged(address: String) {
        viewModelScope.launch {
            deliveryAddressFlow.value = address
        }
    }

    fun onPasswordChanged(password: String) {
        viewModelScope.launch {
            passwordFlow.value = password
        }
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        viewModelScope.launch {
            confirmPasswordFlow.value = confirmPassword
        }
    }

    fun onPasswordVisible() {
        viewModelScope.launch {
            passwordVisible.value = !passwordVisible.value
        }
    }

    fun isSignUpDataEvaluated() =
        userNameFlow.value.isNotEmpty() && userMobileFlow.value.isNotEmpty() && userEmailFlow.value.isNotEmpty() && passwordFlow.value.isNotEmpty()
                && confirmPasswordFlow.value.isNotEmpty() && passwordFlow.value == confirmPasswordFlow.value

    fun signUp(onSignUp: (Result<SignUpResponse>) -> Unit) {
        //header to send with request
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN

        //params to send with request
        val params = JsonObject()
        params.addProperty(Keys.NAME, userNameFlow.value)
        params.addProperty(Keys.MOBILE_NUMBER, userMobileFlow.value)
        params.addProperty(Keys.PASSWORD, passwordFlow.value)
        params.addProperty(Keys.Address, deliveryAddressFlow.value)
        params.addProperty(Keys.EMAIL, userEmailFlow.value)
        getSignUpData(OderPostModel(header, params), onSignUp)

    }


    fun getSignUpData(oderPostModel: OderPostModel, onSignUp: (Result<SignUpResponse>) -> Unit) {
        viewModelScope.launch {
            getSignupUseCase(oderPostModel).collect {
                onSignUp(it)
            }
        }
    }
}