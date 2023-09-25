package com.sorabh.grabfood.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.ui.theme.spacing
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