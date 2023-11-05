package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.EditLocation
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.component.showToast
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen( viewModel: SignUpViewModel, navController: NavController) {
    SignContent(viewModel = viewModel, navController = navController)
}

@Composable
private fun SignContent(
    viewModel: SignUpViewModel,
    navController: NavController
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space48))

        OutlinedTextField(
            value = viewModel.userNameFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onUserNameChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = { Text(text = stringResource(id = R.string.name)) },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = "person icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        OutlinedTextField(
            value = viewModel.userMobileFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onMobileChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.mobile))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Phone, contentDescription = "phone icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        OutlinedTextField(
            value = viewModel.userEmailFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onEmailChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = "email icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        OutlinedTextField(
            value = viewModel.deliveryAddressFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onAddressChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.delivery_address))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.EditLocation, contentDescription = "address icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        OutlinedTextField(
            value = viewModel.passwordFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            trailingIcon = {
                IconButton(onClick = viewModel::onPasswordVisible) {
                    Icon(
                        imageVector = if (viewModel.passwordVisible.collectAsStateWithLifecycle().value) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = if (viewModel.passwordVisible.collectAsStateWithLifecycle().value) "Hide password" else "Show password"
                    )
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "phone icon")
            },
            visualTransformation = if (viewModel.passwordVisible.collectAsStateWithLifecycle().value) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        OutlinedTextField(
            value = viewModel.confirmPasswordFlow.collectAsStateWithLifecycle().value,
            onValueChange = viewModel::onConfirmPasswordChanged,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.confirm_password))
            },
            trailingIcon = {
                IconButton(onClick = viewModel::onPasswordVisible) {
                    Icon(
                        imageVector =
                        if (viewModel.confirmPasswordVisible.collectAsStateWithLifecycle().value)
                            Icons.Filled.Visibility
                        else
                            Icons.Filled.VisibilityOff,
                        contentDescription =
                        if (viewModel.confirmPasswordVisible.collectAsStateWithLifecycle().value)
                            "Hide password"
                        else
                            "Show password"
                    )
                }
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "phone icon")
            },
            visualTransformation =
            if (viewModel.confirmPasswordVisible.collectAsStateWithLifecycle().value)
                PasswordVisualTransformation()
            else
                VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        Button(
            onClick = {
                viewModel.signUp {
                    if (it is Result.Success) {
                        context.showToast("You successfully SignUp!")
                        navController.navigate(ScreenNavigator.LoginScreen.name)
                    }
                }
            },
            enabled = viewModel.isSignUpDataEvaluated()
        ) {
            Text(
                text = stringResource(id = R.string.btn_signup),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space48))
    }
}