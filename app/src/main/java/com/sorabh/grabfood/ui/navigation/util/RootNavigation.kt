package com.sorabh.grabfood.ui.navigation.util

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sorabh.grabfood.ui.screens.MainScreen
import com.sorabh.grabfood.ui.screens.SplashScreen

@Composable
fun RootNavigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = ScreenNavigator.SplashScreen.name){
        composable(ScreenNavigator.SplashScreen.name){
            SplashScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(ScreenNavigator.MainScreen.name){
            MainScreen(viewModel = hiltViewModel())
        }

        authNavigation(navController = navController)


    }
}