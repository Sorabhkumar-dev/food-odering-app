package com.sorabh.grabfood.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.RestaurantsHomeCardviewBinding
import com.sorabh.grabfood.domain.model.reataurants_home_response.Dish
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.util.RestaurantDiffUtil
import kotlinx.coroutines.*
import javax.inject.Inject

class RestaurantHomeAdapter @Inject constructor(private val localDBRepository: LocalDBRepository) :
    RecyclerView.Adapter<RestaurantViewHolder>() {
    var restaurantsClicked: RestaurantViewHolder.OnRestaurantsClicked? = null
    var onFavoriteButtonClicked: RestaurantViewHolder.OnFavoriteButtonClicked? = null
    private var restaurantsList:MutableList<Dish> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RestaurantViewHolder(RestaurantsHomeCardviewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val restaurant = localDBRepository.getRestaurant(restaurantsList[position].id)
            if (restaurant != null) {
                withContext(Dispatchers.Main) {
                    holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_adapter)
                }
            }
        }
        holder.binding.data = restaurantsList[position]
        holder.binding.onRestaurantClicked = restaurantsClicked
        holder.binding.onFavoriteButtonClicked = object:RestaurantViewHolder.OnFavoriteButtonClicked{
            override fun onFavoriteButtonClicked(dish: Dish) {
                CoroutineScope(Dispatchers.IO).launch {
                    if (localDBRepository.getRestaurant(dish.id) != null) {
                        localDBRepository.deleteRestaurant(dish)
                        withContext(Dispatchers.Main) {
                            holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_empty)
                        }
                    } else {
                        localDBRepository.insertRestaurant(dish)
                        withContext(Dispatchers.Main) {
                            holder.binding.cardViewImgBtnFavorite.setImageResource(R.drawable.ic_favorite_adapter)
                        }
                    }
                }
            }

        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = restaurantsList.size

    fun updateRestaurantsList(newList: List<Dish>?) {
        newList?.let {
            val diffResult = DiffUtil.calculateDiff(RestaurantDiffUtil(newList, restaurantsList))
            this.restaurantsList.addAll(it)
            diffResult.dispatchUpdatesTo(this)
        }
    }
}

class RestaurantViewHolder(val binding: RestaurantsHomeCardviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    interface OnFavoriteButtonClicked {
        fun onFavoriteButtonClicked(dish: Dish)
    }

    interface OnRestaurantsClicked {
        fun onRestaurantsClicked(dish: Dish)
    }
}