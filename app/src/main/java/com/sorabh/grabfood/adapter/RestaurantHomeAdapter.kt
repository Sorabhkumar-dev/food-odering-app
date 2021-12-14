package com.sorabh.grabfood.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.api_response_classes.reataurants_home_response.DataX
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding
import com.sorabh.grabfood.repository.LocalDBRepository
import com.sorabh.grabfood.util.RestaurantDiffUtil
import kotlinx.coroutines.*

class RestaurantHomeAdapter(
    private val restaurantsClicked: RestaurantViewHolder.OnRestaurantsClicked,
    private val onFavoriteButtonClicked: RestaurantViewHolder.OnFavoriteButtonClicked,
    val context: Context
) :
    RecyclerView.Adapter<RestaurantViewHolder>() {

    private var restaurantsList = ArrayList<DataX>()
    val job = SupervisorJob()
    private val localRepoStory = LocalDBRepository(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val restaurantsHomeCardViewBinding: RestaurantsHomeCardviewBinding =
            DataBindingUtil.inflate(
                layoutInflater,
                R.layout.restaurants_home_cardview, parent, false
            )
        return RestaurantViewHolder(restaurantsHomeCardViewBinding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        CoroutineScope(job + Dispatchers.IO).launch {
            val restaurant = localRepoStory.getRestaurant(restaurantsList[position].id)
            if (restaurant != null) {
                withContext(Dispatchers.Main) {
                    holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_adapter)
                }
            }
        }
        holder.binding.data = restaurantsList[position]
        holder.binding.onRestaurantClicked = restaurantsClicked
        holder.binding.onFavoriteButtonClicked = onFavoriteButtonClicked
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = restaurantsList.size

    fun updateRestaurantsList(list: List<DataX>?) {
        val restaurantCallBack = RestaurantDiffUtil(list, restaurantsList)
        val diffResult = DiffUtil.calculateDiff(restaurantCallBack)
        this.restaurantsList = list as ArrayList<DataX>
        diffResult.dispatchUpdatesTo(this)
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<DataX>?){
        this.restaurantsList.clear()
        this.restaurantsList = list as ArrayList<DataX>
        notifyDataSetChanged()
    }
}

class RestaurantViewHolder(val binding: RestaurantsHomeCardviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    interface OnFavoriteButtonClicked {
        fun onFavoriteButtonClicked(dataX: DataX)
    }

    interface OnRestaurantsClicked {
        fun onRestaurantsClicked(dataX: DataX)
    }
}