package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sorabh.grabfood.domain.datastore.PreferenceData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(preferenceData: PreferenceData):ViewModel(){
    val isLoginFlow = preferenceData.readIsLoginFlow
}