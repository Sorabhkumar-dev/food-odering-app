package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.domain.model.oder_history_response.OderHistory
import com.sorabh.grabfood.domain.model.post.OderHistoryPost
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.usecase.GetOderHistoryUseCase
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OderHistoryVieModel @Inject constructor(
    private val getOderHistoryUseCase: GetOderHistoryUseCase,
    private val preferenceData: PreferenceData
) : ViewModel() {
    private val _oderHistoryFlow: MutableStateFlow<Result<OderHistory>> =
        MutableStateFlow(Result.Loading())
    val oderHistoryFlow: StateFlow<Result<OderHistory>> = _oderHistoryFlow

    init {
        setupApiCall()
    }

    private fun setupApiCall() {
        viewModelScope.launch {
            val header = HashMap<String, String>()
            header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
            header[Keys.TOKEN] = Constants.MAIN_TOKEN
            preferenceData.readUserIdFlow.collectLatest {
                getOderHistory(OderHistoryPost(header, it))
            }
        }
    }

    private suspend fun getOderHistory(oderHistoryPost: OderHistoryPost) {
        getOderHistoryUseCase(oderHistoryPost).collect {
            _oderHistoryFlow.emit(it)
        }
    }
}