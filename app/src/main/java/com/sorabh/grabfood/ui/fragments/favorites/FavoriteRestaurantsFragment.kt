package com.sorabh.grabfood.ui.fragments.favorites

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FavoriteRestaurantsFragmentBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.ui.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.ui.adapter.RestaurantViewHolder
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteRestaurantsFragment : Fragment(),
    RestaurantViewHolder.OnRestaurantsClicked,
    RestaurantViewHolder.OnFavoriteButtonClicked {
    private lateinit var binding:FavoriteRestaurantsFragmentBinding
    private val job = SupervisorJob()

    @Inject
    lateinit var restaurantHomeAdapter: RestaurantHomeAdapter
    @Inject
    lateinit var localDBRepository: LocalDBRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FavoriteRestaurantsFragmentBinding.inflate(layoutInflater)
        //Changing toolbar title
        (activity as AppCompatActivity).supportActionBar?.title = "My Favorite Restaurants"


        CoroutineScope(job + Dispatchers.IO).launch {
            restaurantHomeAdapter.restaurantsClicked = this@FavoriteRestaurantsFragment
            restaurantHomeAdapter.onFavoriteButtonClicked = this@FavoriteRestaurantsFragment

            val lytManager = LinearLayoutManager(activity as Context)
            lateinit var favoriteRestaurantList: List<Dish>
            try {
                favoriteRestaurantList = getFavoriteRestaurantList()!!
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity as Context,
                        "Failed to connect Server",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            withContext(Dispatchers.Main) {
                with(binding.favoriteRestaurantRecyclerview) {
                    adapter = restaurantHomeAdapter
                    layoutManager = lytManager
                    restaurantHomeAdapter.updateRestaurantsList(favoriteRestaurantList)
                    binding.favoriteRestaurantProgressBar.visibility =
                        ProgressBar.GONE
                }
            }
        }

        return binding.root
    }

    private suspend fun getFavoriteRestaurantList(): List<Dish>? = coroutineScope {
        val list = CoroutineScope(job + Dispatchers.IO).async {
            return@async localDBRepository.getRestaurantList()
        }
        return@coroutineScope list.await()

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
        Log.d("exc", "executed")
        CoroutineScope(job + Dispatchers.IO).launch {

            val restaurantData = localDBRepository.getRestaurant(dish.id)

            if (restaurantData != null) {
                localDBRepository.deleteRestaurant(dish)
                val list = localDBRepository.getRestaurantList()
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Deleted to Your Favorite Restaurant",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    restaurantHomeAdapter.updateRestaurantsList(list)
                }
            } else {
                localDBRepository.insertRestaurant(dish)
                val list = localDBRepository.getRestaurantList()
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Added  to Your Favorite Restaurant",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    restaurantHomeAdapter.updateRestaurantsList(list)

                }
            }
        }
    }
}