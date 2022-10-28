package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.api_response_classes.otp_response.OTPResponse
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetOTPUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(private val getOTPUseCase: GetOTPUseCase) : ViewModel() {
    private val _otpFlow: MutableStateFlow<Result<OTPResponse>> = MutableStateFlow(Result.Loading())
    val otpFlow: StateFlow<Result<OTPResponse>> = _otpFlow

    fun getOtp(postModel: OderPostModel) {
        viewModelScope.launch {
            getOTPUseCase(postModel).collect {
                when (it) {
                    is Result.Error -> _otpFlow.emit(it)
                    is Result.Loading -> _otpFlow.emit(it)
                    is Result.Success -> _otpFlow.emit(it)
                }
            }
        }
    }
}