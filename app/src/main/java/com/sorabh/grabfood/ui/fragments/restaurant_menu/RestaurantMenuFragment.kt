package com.sorabh.grabfood.ui.fragments.restaurant_menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.adapter.RestaurantMenuAdapter
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.cart.CartFragment
import kotlinx.coroutines.*

class RestaurantMenuFragment(
    private val dataX: com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX
) :
    Fragment() {
    private lateinit var binding: FragmentRestaurantMenuBinding

    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRestaurantMenuBinding.inflate(layoutInflater)

        //Changing toolbar title
        (activity as AppCompatActivity).supportActionBar?.title = dataX.name


        val layout = LinearLayoutManager(activity as Context)
        val restaurantMenuAdapter = RestaurantMenuAdapter(activity as Context)

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
            val repository = NetworkRepository()

            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"

            return@async repository.getMenuList(header, dataX.id)

        }
        return@coroutineScope list.await()
    }
}