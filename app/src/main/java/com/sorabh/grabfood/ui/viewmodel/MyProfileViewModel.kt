package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.grabfood.domain.datastore.PreferenceData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyProfileViewModel @Inject constructor(preferenceData: PreferenceData):ViewModel() {
    val nameFlow = preferenceData.readNameFlow
    val addressFow = preferenceData.readAddressFlow
    val emailFlow = preferenceData.readEmailFlow
    val phoneFlow = preferenceData.readMobileNumberFlow
}