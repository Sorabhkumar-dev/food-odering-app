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
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel
import com.sorabh.grabfood.ui.viewmodel.MainViewModel
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel

fun NavGraphBuilder.authNavigation(navController: NavHostController){
    navigation(startDestination = ScreenNavigator.LoginScreen.name, route = Graph.AuthNavigation.name){

        composable(ScreenNavigator.LoginScreen.name) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.SignUpScreen.name) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.ForgotPasswordScreen.name) {
            val viewModel = hiltViewModel<ForgotPasswordViewModel>()
            ForgotPasswordScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(ScreenNavigator.OTPScreen.name.plus("/{phone}")) { backstackEntry ->
            val viewModel = hiltViewModel<OtpViewModel>()
            OTPScreen(
                viewModel = viewModel,
                navController = navController,
                phone = backstackEntry.arguments?.getString("phone")!!
            )
        }

        composable(ScreenNavigator.MainScreen.name){
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(viewModel = viewModel)
        }

    }
}