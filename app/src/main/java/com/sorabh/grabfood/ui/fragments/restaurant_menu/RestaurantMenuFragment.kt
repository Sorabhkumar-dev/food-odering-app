package com.sorabh.grabfood.ui.fragments.restaurant_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.RestaurantMenuViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RestaurantMenuFragment() : BaseFragment() {

    private val viewModel: RestaurantMenuViewModel by viewModels()
    private lateinit var binding: FragmentRestaurantMenuBinding
    @Inject
    lateinit var restaurantMenuAdapter: RestaurantMenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        startupInitializer()
        setOnClickListener()
        setupObserver()
//        setupApiCall()
        return binding.root
    }

//    private fun startupInitializer() {
//        binding = FragmentRestaurantMenuBinding.inflate(layoutInflater)
//        (activity as AppCompatActivity).supportActionBar?.title = dish.name
//
//        restaurantMenuAdapter.deleteMenu = viewModel::deleteMenu
//        restaurantMenuAdapter.insertMenu = viewModel::insertMenu
//        restaurantMenuAdapter.isMenuSaved = viewModel::isMenuSaved
//
//        binding.restaurantMenuRecyclerView.adapter = restaurantMenuAdapter
//    }

    private fun setOnClickListener() {
        binding.btnProceed.setOnClickListener {
            moveToCart()
        }
        binding.errorLayout.btnRetry.setOnClickListener {
            binding.errorLayout.root.visibility = View.GONE
//            setupApiCall()
        }
    }

    private fun moveToCart() {
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

//    private fun setupApiCall() {
//        val header = HashMap<String, String>()
//        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
//        header[Keys.TOKEN] = Constants.MAIN_TOKEN
//        viewModel.getRestaurantMenu(RestaurantMenuPostModel(header, dish.id))
//    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.restaurantMenuFlow.collect {
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
                            it.body?.data?.data.let { menus ->
                                restaurantMenuAdapter.updateRestaurantMenu(menus)
                            }
                        }
                    }
                }
            }
        }
    }
}