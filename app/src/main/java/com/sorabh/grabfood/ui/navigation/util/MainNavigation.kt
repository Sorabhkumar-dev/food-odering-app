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
import com.sorabh.grabfood.ui.viewmodel.CartViewModel
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel
import com.sorabh.grabfood.ui.viewmodel.QNAViewModel
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel

@Composable
fun MainNavigation(modifier: Modifier, navController: NavHostController) {
    NavHost(navController = navController, startDestination = ScreenNavigator.HomeScreen.name) {
        composable(ScreenNavigator.HomeScreen.name) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(navController = navController, modifier = modifier, viewModel = viewModel)
        }

        composable(ScreenNavigator.MyProfileScreen.name) {
            val viewModel = hiltViewModel<MyProfileViewModel>()
            MyProfileScreen(modifier = modifier, viewModel = viewModel)
        }

        composable(ScreenNavigator.MyCartScreen.name) {
            val viewModel = hiltViewModel<CartViewModel>()
            CartScreen(modifier = modifier, viewModel = viewModel)
        }

        composable(ScreenNavigator.FavoriteRestaurantScreen.name) {
            val viewModel = hiltViewModel<FavoriteRestaurantsViewModel>()
            FavoriteRestaurantsScreen(
                modifier = modifier,
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(ScreenNavigator.OderHistoryScreen.name) {
            val viewModel = hiltViewModel<OderHistoryVieModel>()
            OderHistoryScreen(modifier = modifier, viewModel = viewModel)
        }

        composable(ScreenNavigator.QNAScreen.name) {
            val viewModel = hiltViewModel<QNAViewModel>()
            QNAScreen(modifier = modifier, viewModel = viewModel)
        }

        composable(ScreenNavigator.RestaurantMenuScreen.name.plus("/{restaurantId}/{restaurantName}"),
            arguments = listOf(
                navArgument("restaurantId") { type = NavType.StringType },
                navArgument("restaurantName") { type = NavType.StringType }
            )) { navBackStackEntry ->
            val viewModel = hiltViewModel<RestaurantMenuViewModel>()
            RestaurantMenuScreen(
                modifier = modifier,
                restaurantId = navBackStackEntry.arguments?.getString("restaurantId")!!,
                restaurantName = navBackStackEntry.arguments?.getString("restaurantName")!!,
                navController = navController,
                viewModel = viewModel
            )
        }


    }
}