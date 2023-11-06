package com.sorabh.grabfood.domain.local_model.tab

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class HomeTab(val tabImage: ImageVector, @StringRes val tabTitle: Int,val description:String)
