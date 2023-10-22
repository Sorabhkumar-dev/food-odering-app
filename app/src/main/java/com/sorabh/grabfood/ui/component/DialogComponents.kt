package com.sorabh.grabfood.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.theme.spacing

@Composable
fun ShowDialog(
    isShowDialog: Boolean,
    @StringRes title: Int,
    @StringRes message: Int,
    onNegativeBtnClicked: () -> Unit,
    onPositiveBtnClicked: () -> Unit
) {
    if (isShowDialog)
        Dialog(onDismissRequest = onNegativeBtnClicked) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))
                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = stringResource(id = message),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

                Row {
                    Button(
                        onClick = onPositiveBtnClicked,
                        modifier = Modifier.weight(4f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.okay),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))

                    OutlinedButton(
                        onClick = onNegativeBtnClicked,
                        modifier = Modifier.weight(4f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.no),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))
            }
        }
}