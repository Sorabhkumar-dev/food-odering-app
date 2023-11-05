package com.sorabh.grabfood.ui.navigation.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sorabh.grabfood.ui.screens.MainScreen
import com.sorabh.grabfood.ui.screens.SplashScreen
import com.sorabh.grabfood.ui.viewmodel.MainViewModel
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel

@Composable
fun RootNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenNavigator.SplashScreen.name){
        composable(ScreenNavigator.SplashScreen.name){
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.MainScreen.name){
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = viewModel)
        }

        authNavigation(navController = navController)


    }
}