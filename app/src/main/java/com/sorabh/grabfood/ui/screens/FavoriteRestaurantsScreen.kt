package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.ui.component.DishCard
import com.sorabh.grabfood.ui.component.EmptySection
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel

@Composable
fun FavoriteRestaurantsScreen(viewModel: FavoriteRestaurantsViewModel,onDishClicked:(Dish) -> Unit) {
    val dishes = viewModel.getDishesFlow.collectAsStateWithLifecycle().value
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
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
                    modifier = Modifier.fillMaxWidth().height(130.dp),
                    dish = dish,
                    isFavorite = viewModel.isDishStored(dish.id).collectAsStateWithLifecycle(false).value,
                    onFavoriteBtnClicked = viewModel::onFavoriteIconBtnClick,
                    onClick = onDishClicked
                )
            }

    }
}