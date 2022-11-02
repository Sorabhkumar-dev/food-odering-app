
package com.sorabh.grabfood.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentHomeBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import com.sorabh.grabfood.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var restaurantHomeAdapter: RestaurantHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer(inflater)
        setupObserver()
        setOnClickListener()
        return binding.root
    }

    private fun setOnClickListener() {
        binding.errorLayout.btnRetry.setOnClickListener {
            binding.errorLayout.root.visibility = View.GONE
            viewModel.getRestaurants()
        }
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = FragmentHomeBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.restaurants_list)

            restaurantHomeAdapter.isRestaurantStored = viewModel::isRestaurantStored
            restaurantHomeAdapter.insertRestaurant = viewModel::insertRestaurant
            restaurantHomeAdapter.deleteRestaurant = viewModel::deleteRestaurant

        binding.recyclerView.adapter = restaurantHomeAdapter
        restaurantHomeAdapter.restaurantsClicked =
            object : RestaurantViewHolder.OnRestaurantsClicked {
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
            }
    }
    private fun setupObserver() {
        lifecycleScope.launch {
            viewModel.restaurantFlow.collect {
                when (it) {
                    is Result.Loading -> {
                        binding.shimmerLayout.startShimmer()
                        binding.shimmerLayout.visibility = View.VISIBLE
                    }
                    is Result.Error -> {
                        binding.shimmerLayout.stopShimmer()
                        binding.shimmerLayout.visibility = View.GONE
                        binding.errorLayout.root.visibility = View.VISIBLE
                        binding.errorLayout.txvReason.text = it.message
                    }
                    is Result.Success -> {
                        binding.shimmerLayout.stopShimmer()
                        binding.shimmerLayout.visibility = View.GONE
                        it.body?.data?.data?.let { dishes ->
                            restaurantHomeAdapter.updateRestaurantsList(dishes)
                        }
                    }
                }
            }
        }
    }
}