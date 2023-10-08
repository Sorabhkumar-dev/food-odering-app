package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.post.LoginPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getLoginResponseUseCase: GetLoginResponseUseCase,
    private val preferenceDataStore: PreferenceData
) : ViewModel() {
    private val _loginFlow: MutableStateFlow<Result<LoginResponse>> =
        MutableStateFlow(Result.Loading())

    val isLoginFlow = preferenceDataStore.readIsLoginFlow


    val userPhoneFlow = MutableStateFlow("")
    val userPasswordFlow = MutableStateFlow("")

    fun onUserPhoneChanged(phone: String) {
        userPhoneFlow.value = phone
    }

    fun onUserPasswordChanged(password: String) {
        userPasswordFlow.value = password
    }

    fun login() {
        //params to send with request
        val params = JsonObject().apply {
            addProperty(Keys.MOBILE_NUMBER, userPhoneFlow.value)
            addProperty(Keys.PASSWORD, userPasswordFlow.value)
        }
        //header to send
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN
        getLoginDetails(LoginPostModel(header, params))
    }

    private fun getLoginDetails(loginPostModel: LoginPostModel) {
        viewModelScope.launch {
            getLoginResponseUseCase(loginPostModel).collect {
                if (it is Result.Success) {
                    saveLoginData(it.body!!)
                    _loginFlow.emit(it)
                }
            }
        }
    }

    private fun saveLoginData(loginData: LoginResponse) {
        viewModelScope.launch {
            writeName(loginData.data.data.name)
            writeAddress(loginData.data.data.address)
            writeEmail(loginData.data.data.email)
            writeUserId(loginData.data.data.user_id)
            writeMobileNumber(loginData.data.data.mobile_number)
            writeIsLogin(true)
        }
    }


    private suspend fun writeName(name: String) = preferenceDataStore.writeName(name)

    private suspend fun writeAddress(address: String) = preferenceDataStore.writeAddress(address)

    private suspend fun writeEmail(email: String) = preferenceDataStore.writeEmail(email)

    private suspend fun writeMobileNumber(mobileNumber: String) =
        preferenceDataStore.writeMobileNumber(mobileNumber)

    private suspend fun writeUserId(userId: String) = preferenceDataStore.writeUserId(userId)

    private suspend fun writeIsLogin(isLogin: Boolean) = preferenceDataStore.writeIsLogin(isLogin)
}