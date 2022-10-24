package com.sorabh.grabfood.ui.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sorabh.grabfood.R
import com.sorabh.grabfood.adapter.RestaurantHomeAdapter
import com.sorabh.grabfood.adapter.RestaurantViewHolder
import com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX
import com.sorabh.grabfood.databinding.FragmentHomeBinding
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.restaurant_menu.RestaurantMenuFragment
import kotlinx.coroutines.*


class HomeFragment : BaseFragment(),
    RestaurantViewHolder.OnRestaurantsClicked,
    RestaurantViewHolder.OnFavoriteButtonClicked {
    private lateinit var binding: FragmentHomeBinding
    private val job = SupervisorJob()

    private lateinit var restaurantHomeAdapter: RestaurantHomeAdapter

    private lateinit var networkRepository: NetworkRepository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        (activity as AppCompatActivity).supportActionBar?.title = "Restaurant List"
        restaurantHomeAdapter = RestaurantHomeAdapter(this, this, activity as Context)

        networkRepository = NetworkRepository()
        val layout = LinearLayoutManager(activity as Context)
        with(binding.recyclerView) {
            layoutManager = layout
            adapter = restaurantHomeAdapter
        }

        CoroutineScope(job + Dispatchers.Main).launch {
            try {

                val list = getRestaurantsList()
                if (list != null) {
                    restaurantHomeAdapter.updateRestaurantsList(list)
                    binding.progressbar.visibility = ProgressBar.GONE
                }
            } catch (e: Exception) {
                Toast.makeText(
                    activity as Context,
                    "Couldn't Connect To Server",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
//        onSearch(mainBinding.searchView)
        return binding.root
    }

//    private fun onSearch(searchView: SearchView) = CoroutineScope(Dispatchers.IO).launch {
//        searchView.queryHint = "Search Restaurants Here"
//        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                Log.d("excc",newText!!)
//                CoroutineScope(job + Dispatchers.IO).launch{
//                    var list :List<DataX>? =null
//                    try {
//                         list = getRestaurantsList()
//                    }catch (e:java.lang.Exception){
//
//                    }
//                    val restaurantList = ArrayList<DataX>()
//                    if (list != null) {
//                        for (i in list){
//                            if (i.name.lowercase().startsWith(newText)){
//                                restaurantList.add(i)
//                            }
//                        }
//                        withContext(Dispatchers.Main) {
//                            restaurantHomeAdapter.updateList(restaurantList)
//                            homeBinding.progressbar.visibility = ProgressBar.GONE
//
//                        }
//                    }
//                }
//                return true
//            }
//
//        })
//    }

    private suspend fun getRestaurantsList(): List<DataX>? = coroutineScope {
        val list = CoroutineScope(job + Dispatchers.IO).async {
            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"
            return@async networkRepository.getRestaurantsList(header)
        }
        return@coroutineScope list.await()
    }

    override fun onRestaurantsClicked(dataX: DataX) {
        parentFragmentManager.beginTransaction()
            .setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )
            .addToBackStack("RestaurantMenuFragment")
            .replace(R.id.frameLayout, RestaurantMenuFragment(dataX))
            .commit()
    }

    override fun onFavoriteButtonClicked(dataX: DataX) {
        CoroutineScope(job + Dispatchers.IO).launch {
            val localDBRepository = LocalDBRepository(activity as Context)

            val localData = localDBRepository.getRestaurant(dataX.id)

            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"


            var restaurantList :List<DataX>?
            if (localData != null) {
                localDBRepository.deleteRestaurant(dataX)
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity as Context,
                        "Delete to your favorite",
                        Toast.LENGTH_SHORT
                    ).show()
                    try {
                        restaurantList = networkRepository.getRestaurantsList(header)
                        restaurantHomeAdapter.updateList(restaurantList)
                    } catch (e: java.lang.Exception) {
                        
                    }
                }
            } else {
                localDBRepository.insertRestaurant(dataX)
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity as Context,
                        "Added to your favorite",
                        Toast.LENGTH_SHORT
                    ).show()
                    try {
                        restaurantList = networkRepository.getRestaurantsList(header)
                        restaurantHomeAdapter.updateList(restaurantList)
                    } catch (_: java.lang.Exception) {

                    }
                }
            }
        }
    }


}