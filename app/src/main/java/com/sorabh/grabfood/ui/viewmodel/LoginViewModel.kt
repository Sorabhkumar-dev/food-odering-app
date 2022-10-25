package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.post.LoginPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetLoginResponseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val getLoginResponseUseCase: GetLoginResponseUseCase):ViewModel() {
    private val _loginFlow:MutableStateFlow<Result<LoginResponse>> = MutableStateFlow(Result.Loading())
    val loginFlow:StateFlow<Result<LoginResponse>> = _loginFlow

    fun getLoginDetails(loginPostModel: LoginPostModel){
        viewModelScope.launch {
            getLoginResponseUseCase(loginPostModel).collect {
                when (it) {
                    is Result.Error -> _loginFlow.emit(it)
                    is Result.Loading -> _loginFlow.emit(it)
                    is Result.Success ->_loginFlow.emit(it)
                }
            }
        }
    }
}