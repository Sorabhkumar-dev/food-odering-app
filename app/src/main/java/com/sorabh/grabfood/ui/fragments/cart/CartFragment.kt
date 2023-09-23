package com.sorabh.grabfood.ui.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sorabh.grabfood.ui.adapter.CartAdapter
import com.sorabh.grabfood.ui.screens.CartScreen
import com.sorabh.grabfood.ui.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()

    @Inject
    lateinit var cartAdapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = ComposeView(requireContext()).apply{
        setContent {
            CartScreen(viewModel = viewModel)
        }
    }
}
