package com.sorabh.grabfood.ui.fragments.qna

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sorabh.grabfood.ui.screens.QNAScreen
import com.sorabh.grabfood.ui.viewmodel.QNAViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QNAFragment : Fragment() {

    private val viewModel: QNAViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            QNAScreen(viewModel = viewModel)
        }
    }
}