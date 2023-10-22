package com.sorabh.grabfood.ui.navigation.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QuestionAnswer
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.sorabh.grabfood.R

data class DrawerNavigationItem(@StringRes val drawerText:Int,val drawerIcon:ImageVector)

val drawerNavigationItems = mutableStateListOf(
    DrawerNavigationItem(R.string.menu_home, Icons.Outlined.Home),
    DrawerNavigationItem(R.string.menu_profile, Icons.Outlined.Person),
    DrawerNavigationItem(R.string.menu_cart, Icons.Outlined.ShoppingCart),
    DrawerNavigationItem(R.string.menu_favorite, Icons.Outlined.FavoriteBorder),
    DrawerNavigationItem(R.string.menu_history, Icons.Outlined.History),
    DrawerNavigationItem(R.string.menu_qna, Icons.Outlined.QuestionAnswer),
    DrawerNavigationItem(R.string.menu_logout, Icons.Outlined.Logout),
)
