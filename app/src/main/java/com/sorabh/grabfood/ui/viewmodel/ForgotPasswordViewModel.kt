package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val getForgotPasswordUseCase: GetForgotPasswordUseCase):ViewModel(){

    val userPhoneFlow = MutableStateFlow("")

    val userEmailFlow = MutableStateFlow("")

    fun onUserPhoneChanged(phone:String){
        userPhoneFlow.value =phone
    }

    fun onEmailChanged(email: String){
        userEmailFlow.value = email
    }

    fun forgotPassword(onResult:(Result<ForgotResponse>) -> Unit){
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN

        val params = JsonObject().apply {
            addProperty(Keys.MOBILE_NUMBER, userPhoneFlow.value)

            addProperty(Keys.EMAIL, userEmailFlow.value)
        }
        getForgotPassword(OderPostModel(header, params),onResult)
    }
    private fun getForgotPassword(oderPostModel: OderPostModel, onResult: (Result<ForgotResponse>) -> Unit){
        viewModelScope.launch {
            getForgotPasswordUseCase(oderPostModel).collect{
               onResult(it)
            }
        }
    }
}