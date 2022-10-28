package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.api_response_classes.forgot_response.ForgotResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetForgotPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(private val getForgotPasswordUseCase: GetForgotPasswordUseCase):ViewModel(){
    private val _forgetPasswordFlow:MutableStateFlow<Result<ForgotResponse>> = MutableStateFlow(Result.Loading())
    val forgetPasswordFlow:StateFlow<Result<ForgotResponse>> = _forgetPasswordFlow
    fun getForgotPassword(oderPostModel: OderPostModel){
        viewModelScope.launch {
            getForgotPasswordUseCase(oderPostModel).collect{
                when(it){
                    is Result.Error -> _forgetPasswordFlow.emit(it)
                    is Result.Loading -> _forgetPasswordFlow.emit(it)
                    is Result.Success -> _forgetPasswordFlow.emit(it)
                }
            }
        }
    }

}