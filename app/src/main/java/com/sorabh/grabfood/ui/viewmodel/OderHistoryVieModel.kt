package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.post.OderHistoryPost
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OderHistoryVieModel @Inject constructor(
    private val getOderHistoryUseCase: GetOderHistoryUseCase,
    preferenceData: PreferenceData
) : ViewModel() {
    private val _oderHistoryFlow: MutableStateFlow<Result<OderHistory>> =
        MutableStateFlow(Result.Loading())
    val oderHistoryFlow: StateFlow<Result<OderHistory>> = _oderHistoryFlow

    val userIdFlow = preferenceData.readUserIdFlow
    fun getOderHistory(oderHistoryPost: OderHistoryPost) {
        viewModelScope.launch {
            getOderHistoryUseCase(oderHistoryPost).collect {
                when (it) {
                    is Result.Error -> _oderHistoryFlow.emit(it)
                    is Result.Loading -> _oderHistoryFlow.emit(it)
                    is Result.Success -> _oderHistoryFlow.emit(it)
                }
            }
        }
    }
}