package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.sorabh.grabfood.ui.navigation.util.RootNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            RootNavigation(navController = navHostController )
        }
    }
}