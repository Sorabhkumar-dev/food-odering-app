package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.model.oder_respones.OderConfirmation
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetOderConfirmationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val getOderConfirmationUseCase: GetOderConfirmationUseCase) :
    ViewModel() {
    private val _oderConfirmationFlow: MutableStateFlow<Result<OderConfirmation>> =
        MutableStateFlow(
            Result.Loading()
        )
    val oderConfirmationFlow: StateFlow<Result<OderConfirmation>> = _oderConfirmationFlow

    fun placeOder(oderPostModel: OderPostModel) {
        viewModelScope.launch {
            getOderConfirmationUseCase(oderPostModel).collect {
                when (it) {
                    is Result.Error -> _oderConfirmationFlow.emit(it)
                    is Result.Loading -> _oderConfirmationFlow.emit(it)
                    is Result.Success -> _oderConfirmationFlow.emit(it)
                }
            }
        }
    }
}