package com.sorabh.grabfood.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.domain.model.reataurants_home_response.DataX
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.util.RestaurantDiffUtil
import kotlinx.coroutines.*
import javax.inject.Inject

class RestaurantHomeAdapter @Inject constructor(private val localDBRepository: LocalDBRepository) :
    RecyclerView.Adapter<RestaurantViewHolder>() {
    var restaurantsClicked: RestaurantViewHolder.OnRestaurantsClicked? = null
    var onFavoriteButtonClicked: RestaurantViewHolder.OnFavoriteButtonClicked? = null
    private var restaurantsList = ArrayList<DataX>()
    val job = SupervisorJob()

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
            val restaurant = localDBRepository.getRestaurant(restaurantsList[position].id)
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