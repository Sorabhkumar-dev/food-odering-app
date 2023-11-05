package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.component.DishCard
import com.sorabh.grabfood.ui.component.EmptySection
import com.sorabh.grabfood.ui.component.ErrorSection
import com.sorabh.grabfood.ui.component.HomeTabContent
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier, viewModel: HomeViewModel) {
    HomeContent(modifier = modifier, viewModel = viewModel) { restaurant ->
        navController.navigate(ScreenNavigator.RestaurantMenuScreen.name.plus("/${restaurant.id}/${restaurant.name}"))
    }
}

@Composable
private fun HomeContent(
    modifier: Modifier,
    viewModel: HomeViewModel,
    onDishClicked: (Dish) -> Unit
) {
    Column(modifier = modifier) {
        TabRow(
            selectedTabIndex = viewModel.homeTabs.indexOf(viewModel.selectedTab.collectAsStateWithLifecycle().value),
            modifier = Modifier.fillMaxWidth()
        ) {
            viewModel.homeTabs.forEach { tab ->
                Tab(
                    selected = viewModel.selectedTab.collectAsStateWithLifecycle().value.tabImage == tab.tabImage,
                    onClick = { viewModel.onTabChanged(tab) }) {
                    HomeTabContent(tab = tab)
                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.space6))
                }
            }
        }

        if (viewModel.selectedTab.collectAsStateWithLifecycle().value.tabImage == viewModel.homeTabs.first().tabImage)
            Foods(viewModel, onDishClicked)
    }
}

@Composable
private fun Foods(
    viewModel: HomeViewModel,
    onDishClicked: (Dish) -> Unit
) {
    val dishes = viewModel.restaurantFlow.collectAsStateWithLifecycle().value

    LazyColumn(
        modifier = Modifier,
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        when (dishes) {
            is Result.Error -> item {
                ErrorSection(
                    modifier = Modifier.fillMaxSize(),
                    onRetryBtnClicked = viewModel::getRestaurants
                )
            }

            is Result.Loading -> item {
                Text(text = "Loading....")
            }

            is Result.Success -> if (dishes.body?.data?.data.isNullOrEmpty())
                item {
                    EmptySection(modifier = Modifier.fillMaxWidth())
                }
            else
                items(dishes.body?.data?.data ?: emptyList()) { dish ->
                    DishCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        dish = dish,
                        isFavorite = viewModel.isDishStored(dish.id)
                            .collectAsStateWithLifecycle(0).value > 0,
                        onFavoriteBtnClicked = viewModel::onFavoriteIconBtnClick,
                        onClick = onDishClicked
                    )
                }
        }
    }
}