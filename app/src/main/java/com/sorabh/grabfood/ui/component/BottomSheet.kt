package com.sorabh.grabfood.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.theme.spacing

@Preview
@Composable
fun OderPlaceBottomSheet(
    modifier: Modifier = Modifier,
    isOderPlaced: Boolean = false,
    onOkayBtnClicked: () -> Unit = {}
) {
    Column(modifier = modifier,horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_grab_food),
            contentDescription = "grab logo",
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Icon(
            imageVector = if (isOderPlaced) Icons.Default.Done else Icons.Default.Close,
            contentDescription = "Oder confirmation icon",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(MaterialTheme.spacing.space48)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space8))
        Text(
            text = stringResource(
                id = if (isOderPlaced)
                    R.string.your_oder_successfully_placed
                else
                    R.string.sorry_oder_not_placed
            ),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Button(onClick = onOkayBtnClicked, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.okay),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}