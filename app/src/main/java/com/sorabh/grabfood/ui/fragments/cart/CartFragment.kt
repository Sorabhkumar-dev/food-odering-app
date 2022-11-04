package com.sorabh.grabfood.ui.fragments.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.FragmentCartBinding
import com.sorabh.grabfood.databinding.OderBottomSheetBinding
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.adapter.CartAdapter
import com.sorabh.grabfood.ui.adapter.CartViewHolder
import com.sorabh.grabfood.ui.viewmodel.CartViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()

    private lateinit var binding: FragmentCartBinding

    @Inject
    lateinit var cartAdapter: CartAdapter

    private var localMenu: Menu? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitialization(inflater)
        updateMenuList()
        setupObserver()
        return binding.root
    }

    private fun startupInitialization(inflater: LayoutInflater) {
        binding = FragmentCartBinding.inflate(inflater)
        binding.cartRecyclerView.adapter = cartAdapter
        cartAdapter.onOderButtonClickedListener =
            object : CartViewHolder.OnOderButtonClickedListener {
                override fun onOderButtonClicked(menu: Menu) {
                    placeOrder(menu)
                }
            }
    }

    private fun updateMenuList() {
        lifecycleScope.launch{
            viewModel.menuFlow.collect{
                cartAdapter.updateMenuList(it)
            }
        }
    }

    private fun placeOrder(menu: Menu) {
        localMenu = menu
        val sharedPreferences =
            activity?.getSharedPreferences(Keys.LOGIN, AppCompatActivity.MODE_PRIVATE)
        val userId: String? = sharedPreferences?.getString(Keys.USER_ID, "107")

        val jsonObject = JsonObject()
        jsonObject.addProperty(Keys.USER_ID, userId)
        jsonObject.addProperty(Keys.RESTAURANT_ID, menu.restaurant_id)
        jsonObject.addProperty(Keys.TOTAL_COST, menu.cost_for_one)

        val food = JsonObject()
        food.addProperty(Keys.FOOD_ITEM_ID, menu.id)

        val foodItem = JsonArray()
        foodItem.add(food)

        jsonObject.add(Keys.FOOD, foodItem)

        //header to send
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN
        viewModel.placeOder(OderPostModel(header, jsonObject))
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.oderConfirmationFlow.collect {
                    when (it) {
                        is Result.Error -> {
                            showBottomSheet(false)
                        }
                        is Result.Loading -> {}
                        is Result.Success -> {
                            it.body?.data?.let { isConfirm ->
                                if (isConfirm.success) {
                                    localMenu?.let { menu ->
                                        viewModel.deleteMenu(menu)
                                    }
                                }
                                showBottomSheet(isConfirm.success)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showBottomSheet(isConfirm: Boolean) {
        val oderConfirmation = BottomSheetDialog(requireContext())
        val layoutInflater = LayoutInflater.from(requireContext())

        val bindingSheet = OderBottomSheetBinding.inflate(layoutInflater)

        if (isConfirm) {
            bindingSheet.bottomSheetAction.text = getString(R.string.your_oder_successfully_placed)
            bindingSheet.bottomSheetSign.setImageResource(R.drawable.ic_check_mark)
        } else {
            bindingSheet.bottomSheetAction.text =getString(R.string.sorry_oder_not_placed)
            bindingSheet.bottomSheetSign.setImageResource(R.drawable.ic_unsuccess)
        }
        oderConfirmation.setContentView(bindingSheet.root)
        oderConfirmation.show()
        bindingSheet.btnOkay.setOnClickListener { oderConfirmation.hide() }
    }
}
