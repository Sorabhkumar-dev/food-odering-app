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
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator

data class DrawerNavigationItem(@StringRes val drawerText:Int,val drawerIcon:ImageVector,val screen:String = ScreenNavigator.HomeScreen.name)

val drawerNavigationItems = mutableStateListOf(
    DrawerNavigationItem(R.string.menu_home, Icons.Outlined.Home,ScreenNavigator.HomeScreen.name),
    DrawerNavigationItem(R.string.menu_profile, Icons.Outlined.Person,ScreenNavigator.MyProfileScreen.name),
    DrawerNavigationItem(R.string.menu_cart, Icons.Outlined.ShoppingCart,ScreenNavigator.MyCartScreen.name),
    DrawerNavigationItem(R.string.menu_favorite, Icons.Outlined.FavoriteBorder,ScreenNavigator.FavoriteScreen.name),
    DrawerNavigationItem(R.string.menu_history, Icons.Outlined.History,ScreenNavigator.OderHistoryScreen.name),
    DrawerNavigationItem(R.string.menu_qna, Icons.Outlined.QuestionAnswer,ScreenNavigator.QNAScreen.name),
    DrawerNavigationItem(R.string.menu_logout, Icons.Outlined.Logout,ScreenNavigator.LogoutDialog.name),
)
