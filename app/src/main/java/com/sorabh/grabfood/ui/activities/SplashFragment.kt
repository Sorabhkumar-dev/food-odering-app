package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.grabfood.databinding.SplashFragmentBinding
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

@AndroidEntryPoint
class SplashFragment : BaseFragment() {
    private val viewModel: SplashViewModel by viewModels()
    private lateinit var binding: SplashFragmentBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initializer(inflater)
        return binding.root
    }

    private fun initializer(inflater: LayoutInflater) {
        binding = SplashFragmentBinding.inflate(inflater)
        navController = findNavController()
        lifecycleScope.launchWhenResumed {
            delay(2000)
            if (viewModel.isLoginFlow.first()) {
                navController.navigate(SplashFragmentDirections.actionSplashFragmentToMainFragment())
            }
            else
                navController.navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        }
    }
}