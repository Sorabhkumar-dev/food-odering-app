package com.sorabh.grabfood.ui.navigation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sorabh.grabfood.ui.screens.HomeScreen
import com.sorabh.grabfood.ui.screens.MyProfileScreen
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel

@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenNavigator.HomeScreen.name) {
        composable(ScreenNavigator.HomeScreen.name) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(modifier = modifier, viewModel = viewModel) {}
        }

        composable(ScreenNavigator.MyProfileScreen.name) {
            val viewModel = hiltViewModel<MyProfileViewModel>()
            MyProfileScreen(modifier = modifier, viewModel = viewModel)
        }
    }
}