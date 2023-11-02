package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.activities.LoginFragmentDirections
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navController: NavController
) {
    val loginFlow = viewModel.isLoginFlow.collectAsStateWithLifecycle(false).value
    LaunchedEffect(loginFlow) {
        if (loginFlow)
            navController.navigate(
                LoginFragmentDirections
                    .actionLoginFragmentToMainFragment()
            )
    }
    LoginContent(viewModel = viewModel, navController = navController)
}

@Composable
private fun LoginContent(
    viewModel: LoginViewModel,
    navController: NavController
) {

    val passwordVisible = remember { mutableStateOf(false) }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imgLogo, inputMobile, spacerMobile, inputPassword, spacerPassword, btnLogin, spacerBtnLogin, btnForgotPassword, btnSignUp) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.ic_grab_food),
            contentDescription = "grab food",
            modifier = Modifier.constrainAs(imgLogo) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, 48.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            },
            contentScale = ContentScale.Crop
        )

        OutlinedTextField(
            value = viewModel.userPhoneFlow.collectAsState().value,
            onValueChange = viewModel::onUserPhoneChanged,
            modifier = Modifier.constrainAs(inputMobile) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(imgLogo.bottom, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints

            },
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.mobile))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = "phone icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.constrainAs(spacerMobile) {
            top.linkTo(inputMobile.bottom, 24.dp)
        })


        OutlinedTextField(
            value = viewModel.userPasswordFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onUserPasswordChanged,
            modifier = Modifier.constrainAs(inputPassword) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(spacerMobile.bottom, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        imageVector = if (passwordVisible.value) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible.value) "Hide password" else "Show password"
                    )
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "phone icon")
            },
            visualTransformation = if (passwordVisible.value) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.constrainAs(spacerPassword) {
            top.linkTo(inputPassword.bottom, 100.dp)
        })

        Button(
            onClick = viewModel::login,
            modifier = Modifier.constrainAs(btnLogin) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(spacerPassword.bottom)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            },
        ) {
            Text(text = stringResource(id = R.string.btn_login))
        }

        Spacer(modifier = Modifier.constrainAs(spacerBtnLogin) {
            top.linkTo(btnLogin.bottom)
        })

        TextButton(
            onClick = { navController.navigate(ScreenNavigator.ForgotPasswordScreen.name) },
            modifier = Modifier.constrainAs(btnForgotPassword) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(spacerBtnLogin.bottom, 16.dp)
                end.linkTo(parent.end, 24.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(id = R.string.btn_login_forgot_password))
        }


        TextButton(
            onClick = {
                navController.navigate(
                    LoginFragmentDirections
                        .actionLoginFragmentToSignUpFragment()
                )
            },
            modifier = Modifier.constrainAs(btnSignUp) {
                start.linkTo(parent.start, 24.dp)
                end.linkTo(parent.end, 24.dp)
                bottom.linkTo(parent.bottom, 24.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(id = R.string.btn_login_signup))
        }
    }
}