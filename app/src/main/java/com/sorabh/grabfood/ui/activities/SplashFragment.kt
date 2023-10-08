package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.screens.SplashScreen
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment() {
    private val viewModel: SplashViewModel by viewModels()
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply{
        navController = findNavController()
      setContent {
          SplashScreen(viewModel = viewModel, navController = navController)
      }
    }
}