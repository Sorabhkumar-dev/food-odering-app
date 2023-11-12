package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.toArgb
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.sorabh.grabfood.ui.navigation.util.RootNavigation
import com.sorabh.grabfood.ui.theme.AppTheme
import com.sorabh.grabfood.ui.theme.md_theme_light_primary
import com.sorabh.grabfood.ui.viewmodel.RootViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<RootViewModel>()
            AppTheme(useDarkTheme = viewModel.lightMode.collectAsStateWithLifecycle(false).value) {
                LaunchedEffect(viewModel.lightMode.collectAsStateWithLifecycle(false).value) {
                    viewModel.lightMode.collect{
                        window.statusBarColor = if (it) md_theme_light_primary.toArgb() else md_theme_light_primary.toArgb()
                    }
                }
                RootNavigation(navController = rememberNavController())
            }
        }
        hideSystemUI()
    }
    private fun hideSystemUI(){
        actionBar?.hide()
    }

}