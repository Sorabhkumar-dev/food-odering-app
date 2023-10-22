
package com.sorabh.grabfood.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  = ComposeView(requireContext()).apply{
        setContent {
//            HomeScreen(viewModel = viewModel){
//                parentFragmentManager.beginTransaction()
//                    .setCustomAnimations(
//                        R.anim.enter_from_right,
//                        R.anim.exit_to_left,
//                        R.anim.enter_from_left,
//                        R.anim.exit_to_right
//                    )
//                    .addToBackStack("RestaurantMenuFragment")
//                    .replace(R.id.frameLayout, RestaurantMenuFragment(it))
//                    .commit()
//            }
        }
    }
}