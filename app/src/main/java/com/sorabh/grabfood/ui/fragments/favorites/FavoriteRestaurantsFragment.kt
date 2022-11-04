package com.sorabh.grabfood.ui.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import com.sorabh.grabfood.ui.viewmodel.FavoriteRestaurantsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteRestaurantsFragment : BaseFragment(),
    RestaurantViewHolder.OnRestaurantsClicked {
    private lateinit var binding: FavoriteRestaurantsFragmentBinding
    private val viewModel: FavoriteRestaurantsViewModel by viewModels()

    @Inject
    lateinit var restaurantHomeAdapter: RestaurantHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer()
        setupData()
        return binding.root
    }

    private fun startupInitializer() {
        binding = FavoriteRestaurantsFragmentBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.my_favorite_restaurants)
        binding.errorLayout.btnRetry.visibility = View.GONE
        restaurantHomeAdapter.isRestaurantStored = viewModel::isRestaurantStored
        restaurantHomeAdapter.insertRestaurant = viewModel::insertRestaurant
        restaurantHomeAdapter.deleteRestaurant = viewModel::deleteRestaurant
        binding.favoriteRestaurantRecyclerview.adapter = restaurantHomeAdapter
        restaurantHomeAdapter.restaurantsClicked = this
    }

    private fun setupData() {
        lifecycleScope.launch {
            viewModel.getDishesFlow.collect {
                if (it.isEmpty()) {
                    setupEmptyView(true)
                    binding.errorLayout.txvReason.text =
                        getString(R.string.sorry_you_have_not_any_favorite_restaurants)
                } else {
                    restaurantHomeAdapter.updateRestaurantsList(it)
                    setupEmptyView(false)
                }
            }
        }
    }

    private fun setupEmptyView(isShow: Boolean) {
        binding.errorLayout.root.visibility = if (isShow) View.VISIBLE else View.GONE
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
}