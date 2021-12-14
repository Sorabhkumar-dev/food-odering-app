package com.sorabh.grabfood.fragments.restaurant_menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.activities.MainActivity
import com.sorabh.grabfood.adapter.RestaurantMenuAdapter
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.FragmentRestaurantMenuBinding
import com.sorabh.grabfood.fragments.cart.CartFragment
import com.sorabh.grabfood.repository.LocalDBRepository
import com.sorabh.grabfood.repository.NetworkRepository
import kotlinx.coroutines.*

class RestaurantMenuFragment(private val dataX: com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX) :
    Fragment() {
    private lateinit var fragmentRestaurantMenuBinding: FragmentRestaurantMenuBinding

    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentRestaurantMenuBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_restaurant_menu,
            container,
            false
        )

        //Changing toolbar title
        (activity as MainActivity).supportActionBar?.title = dataX.name


        val layout = LinearLayoutManager(activity as Context)
        val restaurantMenuAdapter = RestaurantMenuAdapter(activity as Context)

        with(fragmentRestaurantMenuBinding.restaurantMenuRecyclerView) {
            layoutManager = layout
            adapter = restaurantMenuAdapter
        }

        CoroutineScope(job + Dispatchers.Main).launch {
            val list = getMenuList()
            restaurantMenuAdapter.updateRestaurantMenu(list as ArrayList<DataX>)
            fragmentRestaurantMenuBinding.restaurantMenuProgressBar.visibility = ProgressBar.GONE
        }
        fragmentRestaurantMenuBinding.restaurantMenuProceedCart.setOnClickListener {
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
        return fragmentRestaurantMenuBinding.root
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

    override fun onDestroy() {
        super.onDestroy()
        fragmentRestaurantMenuBinding.unbind()
    }

}