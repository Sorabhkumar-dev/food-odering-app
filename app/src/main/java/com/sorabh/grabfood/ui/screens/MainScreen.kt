package com.sorabh.grabfood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.NightsStay
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.sorabh.grabfood.R
import com.sorabh.grabfood.ui.component.ShowDialog
import com.sorabh.grabfood.ui.navigation.model.drawerNavigationItems
import com.sorabh.grabfood.ui.navigation.util.MainNavigation
import com.sorabh.grabfood.ui.navigation.util.ScreenNavigator
import com.sorabh.grabfood.ui.theme.spacing
import com.sorabh.grabfood.ui.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerTopSection(
                    modifier = Modifier.fillMaxWidth(),
                    viewModel = viewModel
                )
                Divider()

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.space16))

                LazyColumn {
                    items(drawerNavigationItems) { item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = stringResource(id = item.drawerText),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            selected = viewModel.selectedNavigationItem.collectAsStateWithLifecycle().value.screen === item.screen,
                            onClick = {
                                coroutineScope.launch {
                                    if (item.screen == ScreenNavigator.LogoutDialog.name)
                                        viewModel.onShowLogoutValueChanged(true)
                                    else if (viewModel.selectedNavigationItem.value.screen != item.screen) {
                                        viewModel.onSelectedNavigationChanged(item)
                                        navController.navigate(item.screen)
                                    }
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = item.drawerIcon,
                                    contentDescription = "${item.drawerIcon.name} icon"
                                )
                            }
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
    ) {
        Scaffold(
            modifier = Modifier.width(LocalConfiguration.current.screenWidthDp.dp),
            topBar = {
                CenterAlignedTopAppBar(title = {
                    Text(
                        text = navController.currentDestination?.route?.replace("Screen", "")
                            ?: stringResource(id = R.string.na),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Outlined.Menu,
                                contentDescription = "menu icon",
                                modifier = Modifier.size(MaterialTheme.spacing.space32)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = viewModel::writeDarkMode) {
                            Icon(
                                imageVector =
                                if (viewModel.lightMode.collectAsStateWithLifecycle(false).value)
                                    Icons.Outlined.WbSunny
                                else
                                    Icons.Outlined.NightsStay,
                                contentDescription = "light mode icon"
                            )
                        }
                    }
                )
            }
        ) {
            MainNavigation(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                navController = navController
            )
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