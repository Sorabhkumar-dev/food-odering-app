package com.sorabh.grabfood.ui.navigation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sorabh.grabfood.ui.screens.CartScreen
import com.sorabh.grabfood.ui.screens.FavoriteRestaurantsScreen
import com.sorabh.grabfood.ui.screens.HomeScreen
import com.sorabh.grabfood.ui.screens.MyProfileScreen
import com.sorabh.grabfood.ui.screens.OderHistoryScreen
import com.sorabh.grabfood.ui.screens.QNAScreen
import com.sorabh.grabfood.ui.screens.RestaurantMenuScreen

@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenNavigator.HomeScreen.name) {
        composable(ScreenNavigator.HomeScreen.name) {
            HomeScreen(navController = navController, modifier = modifier, viewModel = hiltViewModel())
        }

        composable(ScreenNavigator.MyProfileScreen.name) {
            MyProfileScreen(modifier = modifier, viewModel = hiltViewModel())
        }

        composable(ScreenNavigator.MyCartScreen.name) {
            CartScreen(modifier = modifier, viewModel = hiltViewModel())
        }

        composable(ScreenNavigator.FavoriteRestaurantScreen.name) {
            FavoriteRestaurantsScreen(
                modifier = modifier,
                navController = navController,
                viewModel = hiltViewModel()
            )
        }

        composable(ScreenNavigator.OderHistoryScreen.name) {
            OderHistoryScreen(modifier = modifier, viewModel = hiltViewModel())
        }

        composable(ScreenNavigator.QNAScreen.name) {
            QNAScreen(modifier = modifier, viewModel = hiltViewModel())
        }

        composable(ScreenNavigator.RestaurantMenuScreen.name.plus("/{restaurantId}/{restaurantName}"),
            arguments = listOf(
                navArgument("restaurantId") { type = NavType.StringType },
                navArgument("restaurantName") { type = NavType.StringType }
            )) { navBackStackEntry ->
            RestaurantMenuScreen(
                modifier = modifier,
                restaurantId = navBackStackEntry.arguments?.getString("restaurantId")!!,
                restaurantName = navBackStackEntry.arguments?.getString("restaurantName")!!,
                navController = navController,
                viewModel = hiltViewModel()
            )
        }


    }
}