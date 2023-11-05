package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.grabfood.ui.component.DishCard
import com.sorabh.grabfood.ui.component.EmptySection
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel

@Composable
fun FavoriteRestaurantsScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: FavoriteRestaurantsViewModel
) {
    val dishes = viewModel.getDishesFlow.collectAsStateWithLifecycle().value
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(MaterialTheme.spacing.space16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.space16)
    ) {
        if (dishes.isEmpty())
            item {
                EmptySection(modifier = Modifier.fillMaxWidth())
            }
        else
            items(dishes) { dish ->
                DishCard(
                    modifier = Modifier.fillMaxWidth(),
                    dish = dish,
                    isFavorite = viewModel.isDishStored(dish.id)
                        .collectAsStateWithLifecycle(0).value > 0,
                    onFavoriteBtnClicked = viewModel::onFavoriteIconBtnClick,
                ) { restaurant ->
                    navController.navigate(ScreenNavigator.RestaurantMenuScreen.name.plus("/${restaurant.id}/${restaurant.name}"))
                }

            }
    }
}