package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sorabh.grabfood.GrabFoodApplication.Companion.R
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.component.ShowDialog
import com.sorabh.grabfood.ui.navigation.model.drawerNavigationItems
import com.sorabh.grabfood.ui.navigation.util.MainNavigation
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()

    DismissibleNavigationDrawer(
        drawerContent = {
                ModalDrawerSheet {
                    NavigationDrawerTopSection(
                        modifier = Modifier.fillMaxWidth(),
                        viewModel = viewModel
                    )
                    Divider(modifier = Modifier)

                    Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))
                    drawerNavigationItems.forEach {
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = stringResource(id = it.drawerText),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            selected = drawerState.currentValue.name == stringResource(id = it.drawerText),
                            onClick = {
                                if (context.R()
                                        .getString(it.drawerText) == drawerState.currentValue.name
                                ) {
                                    coroutineScope.launch {
                                        drawerState.close()
                                    }
                                } else {
                                    if (context.R().getString(R.string.menu_logout) == context.R()
                                            .getString(it.drawerText)
                                    ) viewModel.onShowLogoutValueChanged(true)
                                    else
                                        coroutineScope.launch {
                                            drawerState.snapTo(
                                                DrawerValue.valueOf(
                                                    context.R().getString(it.drawerText)
                                                )
                                            )
                                            drawerState.close()
                                        }
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = it.drawerIcon,
                                    contentDescription = "${it.drawerIcon.name} icon"
                                )
                            }
                        )

                        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

                    }
                }
        },
        modifier = Modifier.fillMaxHeight(),
        drawerState = drawerState,
    ) {
        Scaffold(
            modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp),
            topBar = {
                Row(
                    modifier = Modifier
                        .height(MaterialTheme.spacing.space62)
                        .fillMaxWidth()
                        .background(Color.Cyan),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = drawerState.currentValue.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }) {
            MainNavigation(modifier = Modifier.padding(it), navController = navController)
        }
    }


    ShowDialog(
        isShowDialog = viewModel.isShowLogoutDialog.collectAsStateWithLifecycle().value,
        title = R.string.are_you_sure_to_log_out,
        message = R.string.after_clicking_yes_you_will_be,
        onNegativeBtnClicked = viewModel::onShowLogoutValueChanged
    ) {
        viewModel.onShowLogoutValueChanged()
        viewModel.clearDataStorePreference()
        navController.navigate(ScreenNavigator.LoginScreen.name)
    }
}

@Composable
fun NavigationDrawerTopSection(modifier: Modifier, viewModel: MainViewModel) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        Image(
            painter = painterResource(id = R.drawable.ic_grab_food),
            contentDescription = "grab logo icon",
            modifier = Modifier.height(MaterialTheme.spacing.space130)
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))

        Text(
            text = viewModel.nameFlow.collectAsStateWithLifecycle(stringResource(id = R.string.unknown)).value,
            style = MaterialTheme.typography.titleSmall
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

        Text(
            text = viewModel.emailFlow.collectAsStateWithLifecycle(stringResource(id = R.string.unknown)).value,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.space24))
    }
}