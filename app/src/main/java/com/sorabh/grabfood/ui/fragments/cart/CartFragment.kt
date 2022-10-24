package com.sorabh.grabfood.ui.fragments.cart

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.adapter.CartAdapter
import com.sorabh.grabfood.adapter.CartViewHolder
import com.sorabh.grabfood.api_response_classes.restaurant_menu_response.DataX
import com.sorabh.grabfood.databinding.FragmentCartBinding
import com.sorabh.grabfood.databinding.OderBottomSheetBinding
import com.sorabh.grabfood.domain.repository.LocalDBRepository
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*


class CartFragment : Fragment(), CartViewHolder.OnOderButtonClickedListener {
    private lateinit var fragmentCartBinding: FragmentCartBinding
    private lateinit var localDBRepository: LocalDBRepository
    val job = SupervisorJob()
    private lateinit var cartAdapter: CartAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentCartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        cartAdapter = CartAdapter(activity as Context, this)
        localDBRepository = LocalDBRepository(activity as Context)

        val lytManager = LinearLayoutManager(activity as Context)
        with(fragmentCartBinding.cartRecyclerView) {
            layoutManager = lytManager
            adapter = cartAdapter
        }
        cartAdapter.update()
        fragmentCartBinding.cartProgressBar.visibility = ProgressBar.GONE

        return fragmentCartBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentCartBinding.unbind()
    }

    override fun onOderButtonClicked(menu: DataX) {
        CoroutineScope(Dispatchers.Main).launch {

            val isOderConfirm: Boolean = getOderConfirmation(menu)
            Log.d("oder", isOderConfirm.toString())
            Log.d("exccc", isOderConfirm.toString())
            val oderConfirmation = BottomSheetDialog(activity as Context)
            val layoutInflater = LayoutInflater.from(activity as Context)

            val bindingSheet = DataBindingUtil.inflate<OderBottomSheetBinding>(
                layoutInflater,
                R.layout.oder_bottom_sheet,
                null,
                false
            )
            if (isOderConfirm) {
                val confirmation = "Your Oder Successfully Placed"
                bindingSheet.bottomSheetAction.text = confirmation
                bindingSheet.bottomSheetSign.setImageResource(R.drawable.check_mark)
            } else {
                val confirmation = "Sorry Oder Not Placed"
                bindingSheet.bottomSheetAction.text = confirmation
                bindingSheet.bottomSheetSign.setImageResource(R.drawable.unsuccessful_red)
            }
            oderConfirmation.setContentView(bindingSheet.root)
            oderConfirmation.show()
            withContext(Dispatchers.IO){
                cartAdapter.update()
            }
        }
    }


    private suspend fun getOderConfirmation(dataX: DataX): Boolean {
       val result=  CoroutineScope(job + Dispatchers.IO).async {
            var isOderConfirm = false

            val networkRepository = NetworkRepository()

            val localDBRepository = LocalDBRepository(activity as Context)

            val sharedPreferences =
                activity?.getSharedPreferences("login", AppCompatActivity.MODE_PRIVATE)
            val userId: String? = sharedPreferences?.getString("user_id", "107")

            val jsonObject = JsonObject()
            jsonObject.addProperty("user_id", userId)
            jsonObject.addProperty("restaurant_id", dataX.restaurant_id)
            jsonObject.addProperty("total_cost", dataX.cost_for_one)

            val food = JsonObject()
            food.addProperty("food_item_id", dataX.id)

            val foodItem = JsonArray()
            foodItem.add(food)

            jsonObject.add("food", foodItem)

            //header to send
            val header = HashMap<String, String>()
            header["Content-type"] = "application/json"
            header["token"] = "025c40375fadfd"
            try {
                isOderConfirm = networkRepository.placeOder(header, jsonObject) == true
                if (isOderConfirm) {
                    localDBRepository.deleteMenu(dataX)

                }
            } catch (e: Exception) {
                Log.d("excc", e.message.toString())
            }
            return@async isOderConfirm
        }
       return result.await()
    }
    }
