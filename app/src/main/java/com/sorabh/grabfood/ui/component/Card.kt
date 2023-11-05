package com.sorabh.grabfood.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.model.oder_history_response.Bill
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.QNAData

@Composable
fun CartCard(modifier: Modifier, menu: Menu, onBtnPlaceOrderClicked: (Menu) -> Unit) {
    Card(modifier) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space16)
        ) {
            val (textDishName, textDishPrice, btnPlaceOrder) = createRefs()
            Text(
                text = menu.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.constrainAs(textDishName) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = "$${menu.cost_for_one}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.constrainAs(textDishPrice) {
                    start.linkTo(parent.start)
                    top.linkTo(textDishName.bottom, 8.dp)
                    bottom.linkTo(parent.bottom)
                })

            Button(
                onClick = { onBtnPlaceOrderClicked(menu) },
                modifier = Modifier.constrainAs(btnPlaceOrder) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }) {
                Text(
                    text = stringResource(id = R.string.cart_place_oder),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun QNACard(modifier: Modifier, qnaData: QNAData) {
    Card(modifier = modifier) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space16)
        ) {
            val (textQuestion, textAnswer) = createRefs()
            Text(
                text = "${qnaData.sno}. ${qnaData.question}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.constrainAs(textQuestion) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = qnaData.answer,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(textAnswer) {
                    start.linkTo(parent.start)
                    top.linkTo(textQuestion.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                })
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun OrderHistoryCard(modifier: Modifier, bill: Bill) {
    Card(modifier) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space16)
        ) {
            val (textRestaurantName, textDateTime, dishNames, textPrice) = createRefs()
            Text(
                text = bill.restaurant_name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.constrainAs(textRestaurantName) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

            Text(
                text = Constants.getDate(bill.order_placed_at),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.constrainAs(textDateTime) {
                    top.linkTo(textRestaurantName.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(textRestaurantName.bottom)
                }
            )

            FlowColumn(modifier = Modifier.constrainAs(dishNames) {
                start.linkTo(parent.start)
                top.linkTo(textRestaurantName.bottom, 8.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }) {
                repeat(bill.food_items.size) { index ->
                    Text(
                        text = bill.food_items[index].name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }

            Text(
                text = "Total cost : ${bill.total_cost}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.constrainAs(textPrice) {
                    start.linkTo(parent.start)
                    top.linkTo(dishNames.bottom, 8.dp)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DishCard(
    modifier: Modifier,
    dish: Dish,
    isFavorite: Boolean,
    onFavoriteBtnClicked: (Dish) -> Unit,
    onClick: (Dish) -> Unit
) {
    Card(onClick = { onClick(dish) }, modifier = modifier) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space16)
        ) {
            val (imgDish, textDishName, textDishPrice, textRating, btnFavorite) = createRefs()
            ShowImageFromUrl(
                modifier = Modifier
                    .constrainAs(imgDish) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.value(150.dp)
                        height = Dimension.value(100.dp)
                    }
                    .clip(MaterialTheme.shapes.small),
                url = dish.image_url
            )
            Text(
                text = dish.name,
                modifier = Modifier.constrainAs(textDishName) {
                    start.linkTo(imgDish.end, 16.dp)
                    top.linkTo(imgDish.top)
                },
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = "$${dish.cost_for_one}",
                modifier = Modifier.constrainAs(textDishPrice) {
                    start.linkTo(textDishName.start)
                    top.linkTo(textDishName.bottom, 8.dp)
                },
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )

            RatingCard(
                modifier = Modifier.constrainAs(textRating) {
                    start.linkTo(textDishPrice.start)
                    top.linkTo(textDishPrice.bottom, 8.dp)
                },
                rating = dish.rating
            )
            IconButton(
                onClick = { onFavoriteBtnClicked(dish) },
                modifier = Modifier.constrainAs(btnFavorite) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite Button Icon",
                    modifier = Modifier.size(60.dp),
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuCard(modifier: Modifier, menu: Menu, isSavedMenu: Boolean,onClick:() -> Unit, onMenuClicked: (Menu) -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        shape = MaterialTheme.shapes.small
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.space16)
        ) {
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(text = menu.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "$${menu.cost_for_one}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Button(
                onClick = { onMenuClicked(menu) },
                modifier = Modifier.align(Alignment.CenterEnd),
                colors = ButtonDefaults.buttonColors(
                    animateColorAsState(
                        targetValue = if (isSavedMenu) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                        animationSpec = tween(2000),
                        label = "button color"
                    ).value
                )
            ) {
                Text(
                    text = stringResource(id = if (isSavedMenu) R.string.remove else R.string.add_to_cart),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

    }
}