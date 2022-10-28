package com.sorabh.grabfood.ui.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteRestaurantsFragment : BaseFragment(),
    RestaurantViewHolder.OnRestaurantsClicked,
    RestaurantViewHolder.OnFavoriteButtonClicked {
    private lateinit var binding:FavoriteRestaurantsFragmentBinding

    @Inject
    lateinit var restaurantHomeAdapter: RestaurantHomeAdapter
    @Inject
    lateinit var localDBRepository: LocalDBRepository

    private lateinit var favoriteRestaurantList: List<Dish>

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
        binding.favoriteRestaurantRecyclerview.adapter = restaurantHomeAdapter
        restaurantHomeAdapter.restaurantsClicked = this
        restaurantHomeAdapter.onFavoriteButtonClicked = this
    }

    private fun setupData() {
        lifecycleScope.launch {
            try {
                favoriteRestaurantList = getFavoriteRestaurantList()!!
                restaurantHomeAdapter.updateRestaurantsList(favoriteRestaurantList)
                binding.favoriteRestaurantProgressBar.visibility = ProgressBar.GONE
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showToast(getString(R.string.something_went_wrong))
                }
            }
        }
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

    override fun onFavoriteButtonClicked(dish: Dish) {
        lifecycleScope.launch {
            val restaurantData = localDBRepository.getRestaurant(dish.id)
            if (restaurantData != null) {
                localDBRepository.deleteRestaurant(dish)
                val list = getFavoriteRestaurantList()
                withContext(Dispatchers.Main) {
                    showToast(getString(R.string.deleted_to_your_favorite_restaurants))
                    restaurantHomeAdapter.updateRestaurantsList(list)
                }
            } else {
                localDBRepository.insertRestaurant(dish)
                val list = getFavoriteRestaurantList()
                withContext(Dispatchers.Main) {
                   showToast(getString(R.string.added_to_your_favorite_restaurants))
                    restaurantHomeAdapter.updateRestaurantsList(list)

                }
            }
        }
    }

    private suspend fun getFavoriteRestaurantList(): List<Dish>? = coroutineScope {
        val list = CoroutineScope(Dispatchers.IO).async {
            return@async localDBRepository.getRestaurantList()
        }
        return@coroutineScope list.await()
    }
}