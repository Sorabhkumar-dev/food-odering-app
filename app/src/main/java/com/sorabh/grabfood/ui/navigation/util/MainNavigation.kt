package com.sorabh.grabfood.ui.navigation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sorabh.grabfood.ui.screens.ForgotPasswordScreen
import com.sorabh.grabfood.ui.screens.HomeScreen
import com.sorabh.grabfood.ui.screens.LoginScreen
import com.sorabh.grabfood.ui.screens.OTPScreen
import com.sorabh.grabfood.ui.screens.SignUpScreen
import com.sorabh.grabfood.ui.screens.SplashScreen
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel

@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenNavigator.SplashScreen.name) {
        composable(ScreenNavigator.SplashScreen.name) {
            val viewModel = hiltViewModel<SplashViewModel>()
            SplashScreen(modifier = modifier, viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.LoginScreen.name) {
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(modifier = modifier, viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.SignUpScreen.name) {
            val viewModel = hiltViewModel<SignUpViewModel>()
            SignUpScreen(modifier = modifier, viewModel = viewModel, navController = navController)
        }

        composable(ScreenNavigator.ForgotPasswordScreen.name) {
            val viewModel = hiltViewModel<ForgotPasswordViewModel>()
            ForgotPasswordScreen(
                modifier = modifier,
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(ScreenNavigator.OTPScreen.name.plus("/{phone}")) { backstackEntry ->
            val viewModel = hiltViewModel<OtpViewModel>()
            OTPScreen(
                modifier = modifier,
                viewModel = viewModel,
                navController = navController,
                phone = backstackEntry.arguments?.getString("phone")!!
            )
        }

        composable(ScreenNavigator.HomeScreen.name){
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(modifier = modifier, viewModel = viewModel){}
        }

    }
}