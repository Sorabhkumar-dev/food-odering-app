package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.viewmodel.MyProfileViewModel

@Composable
fun ProfileScreen(viewModel: MyProfileViewModel) {
    ProfileContent(viewModel = viewModel)
}

@Composable
private fun ProfileContent(viewModel: MyProfileViewModel) {
    val userName = viewModel.nameFlow.collectAsStateWithLifecycle(null).value
    val userEmail = viewModel.emailFlow.collectAsStateWithLifecycle(null).value
    val userMobile = viewModel.phoneFlow.collectAsStateWithLifecycle(null).value
    val userAddress = viewModel.addressFow.collectAsStateWithLifecycle(null).value

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (iconLogo, tagBrand, textUserName, textUserEmail, textUserNumber, textUserAddress) = createRefs()

        Card(
            modifier = Modifier
                .constrainAs(iconLogo) {
                    start.linkTo(parent.start, 16.dp)
                    top.linkTo(parent.top, 16.dp)
                    width = Dimension.value(110.dp)
                    height = Dimension.value(110.dp)
                }
                .border(BorderStroke(2.dp, MaterialTheme.colorScheme.primary), CircleShape)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_grab_food),
                contentDescription = "grab logo",
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }

        OutlinedButton(onClick = {}, modifier = Modifier.constrainAs(tagBrand) {
            top.linkTo(parent.top, 16.dp)
            end.linkTo(parent.end, 16.dp)
        }) {
            Text(
                text = stringResource(id = R.string.powered_by_truly),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = userName ?: stringResource(id = R.string.na),
            modifier = Modifier.constrainAs(textUserName) {
                start.linkTo(iconLogo.start)
                top.linkTo(iconLogo.bottom, 16.dp)
            },
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = userEmail ?: stringResource(id = R.string.na),
            modifier = Modifier.constrainAs(textUserEmail) {
                start.linkTo(textUserName.start)
                top.linkTo(textUserName.bottom, 16.dp)
            },
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = userMobile ?: stringResource(id = R.string.na),
            modifier = Modifier.constrainAs(textUserNumber) {
                start.linkTo(textUserEmail.start)
                top.linkTo(textUserEmail.bottom, 16.dp)
            },
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = userAddress ?: stringResource(id = R.string.na),
            modifier = Modifier.constrainAs(textUserAddress) {
                start.linkTo(textUserNumber.start)
                top.linkTo(textUserNumber.bottom)
            },
            style = MaterialTheme.typography.bodyLarge
        )
    }
}