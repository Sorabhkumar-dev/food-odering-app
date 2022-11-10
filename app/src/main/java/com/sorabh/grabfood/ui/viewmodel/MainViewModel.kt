package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.datastore.PreferenceData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val preferenceData: PreferenceData) : ViewModel() {
    val nameFlow = preferenceData.readNameFlow
    val emailFlow = preferenceData.readEmailFlow

    fun clearDataStorePreference() {
        viewModelScope.launch {
            preferenceData.clearDatStore()
        }
    }
}