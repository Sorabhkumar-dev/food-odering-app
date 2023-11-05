package com.sorabh.grabfood.ui.fragments.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.screens.OderHistoryScreen
import com.sorabh.grabfood.ui.viewmodel.OderHistoryVieModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OderHistoryFragment : BaseFragment() {

    private val viewModel: OderHistoryVieModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
//            OderHistoryScreen(viewModel = viewModel)
        }
    }
}