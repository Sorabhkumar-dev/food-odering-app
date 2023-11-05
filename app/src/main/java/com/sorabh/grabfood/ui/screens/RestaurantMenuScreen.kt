package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.component.ErrorSection
import com.sorabh.grabfood.ui.component.MenuCard
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel

@Composable
fun RestaurantMenuScreen(
    modifier: Modifier,
    restaurantId: String,
    restaurantName: String,
    navController: NavController,
    viewModel: RestaurantMenuViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.getRestaurantMenus(restaurantId)
    }
    RestaurantMenuContent(modifier = modifier, navController = navController, viewModel = viewModel)
}

@Composable
private fun RestaurantMenuContent(
    modifier: Modifier,
    navController: NavController,
    viewModel: RestaurantMenuViewModel
) {
    val menus = viewModel.restaurantMenuFlow.collectAsStateWithLifecycle().value
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        when (menus) {
            is Result.Error -> item {
                ErrorSection(modifier = Modifier.fillMaxSize())
            }

            is Result.Loading -> {}

            is Result.Success -> items(menus.body?.data?.data ?: emptyList()) { menu ->
                MenuCard(
                    modifier = Modifier.fillMaxWidth(),
                    menu = menu,
                    isSavedMenu = viewModel.isMenuSaved(menu.id)
                        .collectAsStateWithLifecycle(0).value > 0,
                    onClick = { navController.navigate(ScreenNavigator.MyCartScreen.name) },
                    onMenuClicked = viewModel::onMenuClicked
                )
            }
        }
    }
}