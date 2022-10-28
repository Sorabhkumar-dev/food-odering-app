
package com.sorabh.grabfood.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentHomeBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment(),
    RestaurantViewHolder.OnRestaurantsClicked{
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var repository: NetworkRepository

    @Inject
    lateinit var restaurantHomeAdapter: RestaurantHomeAdapter

    @Inject
    lateinit var localDBRepository: LocalDBRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer(inflater)
        setupObserver()
        return binding.root
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = FragmentHomeBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.restaurants_list)

        binding.recyclerView.adapter = restaurantHomeAdapter
        restaurantHomeAdapter.restaurantsClicked = this
    }

    override fun onRestaurantsClicked(dish: Dish) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .addToBackStack("RestaurantMenuFragment")
            .replace(R.id.frameLayout, RestaurantMenuFragment(dish))
            .commit()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            viewModel.restaurantFlow.collect {
                when (it) {
                    is Result.Error -> {}
                    is Result.Loading -> {}
                    is Result.Success -> {
                        binding.progressbar.visibility = ProgressBar.GONE
                        it.body?.data?.data?.let { dishes ->
                            restaurantHomeAdapter.updateRestaurantsList(dishes)
                        }
                    }
                }
            }
        }
    }

}