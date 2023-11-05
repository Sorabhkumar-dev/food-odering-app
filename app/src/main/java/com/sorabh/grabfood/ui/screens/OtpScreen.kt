package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel

@Composable
fun OTPScreen(
    viewModel: OtpViewModel,
    navController: NavController,
    phone: String
) {
    OTPContent(viewModel = viewModel) {
        viewModel.setupApiCall(phone) {
            if (it is Result.Success)
                navController.navigate(ScreenNavigator.LoginScreen.name)
        }
    }
}

@Composable
private fun OTPContent(viewModel: OtpViewModel, onResetBtnClicked: () -> Unit) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (topSpacer, textHeading, inputOTP, spacerOTP, inputPassword, inputConfirmPassword, spacerPassword, btnResetPassword) = createRefs()

        val passwordVisible = remember { mutableStateOf(false) }

        val confirmPasswordVisible = remember { mutableStateOf(false) }

        Spacer(modifier = Modifier.constrainAs(topSpacer) {
            top.linkTo(parent.top, 48.dp)
        })

        Text(
            text = stringResource(id = R.string.please_enter_previously_send_otp),
            modifier = Modifier.constrainAs(textHeading) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(topSpacer.bottom)
                end.linkTo(parent.end, 24.dp)
                width = Dimension.fillToConstraints
            },
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = viewModel.userOTPFlow.collectAsState().value,
            onValueChange = viewModel::onUserOTPChanged,
            modifier = Modifier.constrainAs(inputOTP) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(textHeading.bottom, 24.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.otp))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = "phone icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.constrainAs(spacerOTP) {
            top.linkTo(inputOTP.bottom, 24.dp)
        })


        OutlinedTextField(
            value = viewModel.passwordFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onPasswordChanged,
            modifier = Modifier.constrainAs(inputPassword) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(spacerOTP.bottom, 16.dp)
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
            top.linkTo(inputPassword.bottom, 24.dp)
        })


        OutlinedTextField(
            value = viewModel.confirmPasswordFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onConfirmPasswordChanged,
            modifier = Modifier.constrainAs(inputConfirmPassword) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(spacerPassword.bottom, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.confirm_password))
            },
            trailingIcon = {
                IconButton(onClick = {
                    confirmPasswordVisible.value = !confirmPasswordVisible.value
                }) {
                    Icon(
                        imageVector = if (confirmPasswordVisible.value) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = if (confirmPasswordVisible.value) "Hide password" else "Show password"
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

        Button(
            onClick = onResetBtnClicked,
            modifier = Modifier.constrainAs(btnResetPassword) {
                start.linkTo(parent.start, 24.dp)
                end.linkTo(parent.end, 24.dp)
                bottom.linkTo(parent.bottom, 48.dp)
                width = Dimension.fillToConstraints
            }) {
            Text(text = stringResource(id = R.string.btn_otp_activity_submit))
        }
    }
}