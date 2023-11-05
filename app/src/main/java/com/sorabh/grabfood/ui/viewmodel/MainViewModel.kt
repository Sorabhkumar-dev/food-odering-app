package com.sorabh.grabfood.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sorabh.grabfood.domain.datastore.PreferenceData
import com.sorabh.grabfood.ui.navigation.model.DrawerNavigationItem
import com.sorabh.grabfood.ui.navigation.model.drawerNavigationItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val preferenceData: PreferenceData) : ViewModel() {

    val selectedNavigationItem:MutableStateFlow<DrawerNavigationItem> = MutableStateFlow(drawerNavigationItems[0])

    val lightMode = preferenceData.readLightModeFlow

    val isShowLogoutDialog = MutableStateFlow(false)
    val nameFlow = preferenceData.readNameFlow
    val emailFlow = preferenceData.readEmailFlow

    fun onSelectedNavigationChanged(drawerNavigationItem: DrawerNavigationItem){
        selectedNavigationItem.value = drawerNavigationItem
    }

    fun writeDarkMode(){
        viewModelScope.launch {
            preferenceData.writeDarkMode(!lightMode.first())
        }
    }

    fun onShowLogoutValueChanged(isShow:Boolean = false){
        viewModelScope.launch {
            isShowLogoutDialog.value = isShow
        }
    }
    fun clearDataStorePreference() {
        viewModelScope.launch {
            preferenceData.clearDatStore()
        }
    }
}