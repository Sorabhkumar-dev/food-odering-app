package com.sorabh.grabfood.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.theme.spacing

@Preview
@Composable
fun EmptySection(modifier: Modifier = Modifier, onRetryBtnClicked: () -> Unit = {}) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        Image(
            painter = painterResource(id = R.drawable.icon_grab_food),
            contentDescription = "Grab food icon",
            modifier = Modifier.height(MaterialTheme.spacing.space150)
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space48))

        Text(
            text = stringResource(id = R.string.there_is_no_item_in_your_cart),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))


        Button(onClick = onRetryBtnClicked, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.retry),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun ErrorSection(modifier: Modifier = Modifier, onRetryBtnClicked: () -> Unit = {}) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        Image(
            painter = painterResource(id = R.drawable.icon_grab_food),
            contentDescription = "Grab food icon",
            modifier = Modifier.height(MaterialTheme.spacing.space150)
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space48))

        Text(
            text = stringResource(id = R.string.there_is_no_item),
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))


        Button(onClick = onRetryBtnClicked, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.retry),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun RatingCard(modifier: Modifier, rating: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "rating icon",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            text = rating,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

    }
}