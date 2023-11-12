package com.sorabh.grabfood.ui.navigation.util

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.sorabh.grabfood.ui.screens.ForgotPasswordScreen
import com.sorabh.grabfood.ui.screens.LoginScreen
import com.sorabh.grabfood.ui.screens.MainScreen
import com.sorabh.grabfood.ui.screens.OTPScreen
import com.sorabh.grabfood.ui.screens.SignUpScreen

fun NavGraphBuilder.authNavigation(navController: NavHostController){
    navigation(startDestination = ScreenNavigator.LoginScreen.name, route = Graph.AuthNavigation.name){

        composable(ScreenNavigator.LoginScreen.name) {
            LoginScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(ScreenNavigator.SignUpScreen.name) {
            SignUpScreen(viewModel = hiltViewModel(), navController = navController)
        }

        composable(ScreenNavigator.ForgotPasswordScreen.name) {
            ForgotPasswordScreen(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable(ScreenNavigator.OTPScreen.name.plus("/{phone}")) { backstackEntry ->
            OTPScreen(
                viewModel = hiltViewModel(),
                navController = navController,
                phone = backstackEntry.arguments?.getString("phone")!!
            )
        }

        composable(ScreenNavigator.MainScreen.name){
            MainScreen(viewModel = hiltViewModel())
        }

    }
}