package com.sorabh.grabfood.ui.fragments.restaurant_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding
import com.sorabh.grabfood.domain.model.post.RestaurantMenuPostModel
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RestaurantMenuFragment(private val dish: Dish) : BaseFragment() {
    private lateinit var binding: FragmentRestaurantMenuBinding

    @Inject
    lateinit var repository: NetworkRepository

    @Inject
    lateinit var restaurantMenuAdapter: RestaurantMenuAdapter

    private val viewModel: RestaurantMenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantMenuBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.title = dish.name
        binding.restaurantMenuRecyclerView.adapter = restaurantMenuAdapter
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN
        viewModel.getRestaurantMenu(RestaurantMenuPostModel(header,dish.id))

        binding.btnProceed.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
                .addToBackStack("CartFragment")
                .replace(R.id.frameLayout, CartFragment())
                .commit()
        }
        setupObserver()
        return binding.root
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.restaurantMenuFlow.collect {
                    when (it) {
                        is Result.Error -> {}
                        is Result.Loading -> {}
                        is Result.Success -> {
                            binding.restaurantMenuProgressBar.visibility = View.GONE
                            it.body?.data?.data?.let { menu ->
                                restaurantMenuAdapter.updateRestaurantMenu(menu)
                            }
                        }
                    }
                }
            }
        }
    }
}