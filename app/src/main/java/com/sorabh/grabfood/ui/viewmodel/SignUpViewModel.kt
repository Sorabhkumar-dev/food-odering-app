package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.api_response_classes.signup_reponse.SignUpResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetSignupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val getSignupUseCase: GetSignupUseCase) :
    ViewModel() {
    private val _signUpFlow: MutableStateFlow<Result<SignUpResponse>> =
        MutableStateFlow(Result.Loading())
    val signUpFlow: StateFlow<Result<SignUpResponse>> = _signUpFlow

    fun getSignUpData(oderPostModel: OderPostModel) {
        viewModelScope.launch {
            getSignupUseCase(oderPostModel).collect {
                when (it) {
                    is Result.Error -> _signUpFlow.emit(it)
                    is Result.Loading -> _signUpFlow.emit(it)
                    is Result.Success -> _signUpFlow.emit(it)
                }
            }
        }
    }
}