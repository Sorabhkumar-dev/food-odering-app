package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@Composable
fun SplashScreen(viewModel: SplashViewModel, navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navController.popBackStack(ScreenNavigator.SplashScreen.name, true)
        if (viewModel.isLoginFlow.first())
            navController.navigate(ScreenNavigator.MainScreen.name)
        else
            navController.navigate(ScreenNavigator.LoginScreen.name)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space48))

        Text(
            text = stringResource(id = R.string.oder_your_food_now),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space70))

        Image(
            painter = painterResource(id = R.drawable.ic_grab_food),
            contentDescription = "grab food logo",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space150))

        CircularProgressIndicator(
            modifier = Modifier.size(MaterialTheme.spacing.space70),
            strokeWidth = MaterialTheme.spacing.space6
        )
    }
}