package com.sorabh.grabfood.ui.fragments.restaurant_menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.adapter.RestaurantMenuAdapter
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
class RestaurantMenuFragment(private val dish: Dish) : BaseFragment() {
    private lateinit var binding: FragmentRestaurantMenuBinding
    @Inject
    lateinit var repository: NetworkRepository

    @Inject
    lateinit var restaurantMenuAdapter: RestaurantMenuAdapter

    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantMenuBinding.inflate(layoutInflater)

        //Changing toolbar title
        (activity as AppCompatActivity).supportActionBar?.title = dish.name


        val layout = LinearLayoutManager(activity as Context)

        with(binding.restaurantMenuRecyclerView) {
            layoutManager = layout
            adapter = restaurantMenuAdapter
        }

        CoroutineScope(job + Dispatchers.Main).launch {
            val list = getMenuList()
            restaurantMenuAdapter.updateRestaurantMenu(list as ArrayList<DataX>)
            binding.restaurantMenuProgressBar.visibility = ProgressBar.GONE
        }
        binding.restaurantMenuProceedCart.setOnClickListener {
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
        return binding.root
    }


    private suspend fun getMenuList(): List<DataX>? = coroutineScope {
        val list = CoroutineScope(job + Dispatchers.IO).async {

            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"

            return@async repository.getMenuList(header, dish.id)

        }
        return@coroutineScope list.await()
    }
}