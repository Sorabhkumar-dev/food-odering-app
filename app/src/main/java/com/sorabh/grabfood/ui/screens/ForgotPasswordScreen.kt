package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.sorabh.grabfood.GrabFoodApplication.Companion.R
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.activities.ForgotPasswordFragmentDirections
import com.sorabh.grabfood.ui.component.showToast
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel
import com.sorabh.grabfood.util.Constants

@Composable
fun ForgotPasswordScreen(viewModel: ForgotPasswordViewModel, navController: NavController) {
    ForgotPasswordContent(viewModel = viewModel, navController = navController)
}

@Composable
private fun ForgotPasswordContent(
    viewModel: ForgotPasswordViewModel,
    navController: NavController
) {
    val context = LocalContext.current
    ConstraintLayout {
        val (imgLogo, textForgotPassword, inputMobile, spacerMobile, inputEmail, btnNext) = createRefs()
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

        Text(
            text = stringResource(id = R.string.txt_forgot_password_heading),
            modifier = Modifier.constrainAs(textForgotPassword) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(imgLogo.bottom, 16.dp)
                end.linkTo(parent.end, 24.dp)
                width = Dimension.fillToConstraints
            },
            color = MaterialTheme.colorScheme.primary
        )

        OutlinedTextField(
            value = viewModel.userPhoneFlow.collectAsState().value,
            onValueChange = viewModel::onUserPhoneChanged,
            modifier = Modifier.constrainAs(inputMobile) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(textForgotPassword.bottom, 16.dp)
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
            value = viewModel.userEmailFlow.collectAsState().value,
            onValueChange = viewModel::onEmailChanged,
            modifier = Modifier.constrainAs(inputEmail) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(spacerMobile.bottom)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints

            },
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "phone icon")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            maxLines = 1
        )

        Button(
            onClick = {
                viewModel.forgotPassword {
                    when (it) {
                        is Result.Error -> {
                            context.showToast(it.message)
                        }

                        is Result.Loading -> {}
                        is Result.Success -> {
                            if (it.body?.data?.success == true && it.body.data.first_try) {
                                context.showToast(
                                    context.R()
                                        .getString(R.string.otp_successfully_send_your_mobile)
                                )
                                navController.navigate(
                                    ForgotPasswordFragmentDirections
                                        .actionForgotPasswordFragmentToOTPFragment(viewModel.userPhoneFlow.value)
                                )
                            } else if (it.body?.data?.success == true && !it.body.data.first_try) {
                                context.showToast(
                                    context.R().getString(R.string.please_enter_previously_send_otp)
                                )
                                navController.navigate(
                                    ForgotPasswordFragmentDirections
                                        .actionForgotPasswordFragmentToOTPFragment(viewModel.userPhoneFlow.value)
                                )

                            } else {
                                context.showToast(Constants.NETWORK_ERROR)
                            }
                        }
                    }
                }
            },
            modifier = Modifier.constrainAs(btnNext) {
                start.linkTo(parent.start, 24.dp)
                top.linkTo(inputEmail.bottom, 120.dp)
                end.linkTo(parent.end, 24.dp)
                width = Dimension.fillToConstraints

            }) {
            Text(text = stringResource(id = R.string.btn_forgot_password_next))
        }
    }
}