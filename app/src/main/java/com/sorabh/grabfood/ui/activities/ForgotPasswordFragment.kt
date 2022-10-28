package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ForgotPasswordFragmentBinding
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.ForgotPasswordViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment() {
    private val viewModel: ForgotPasswordViewModel by viewModels()
    private lateinit var binding: ForgotPasswordFragmentBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer()
        setOnClickListener()
        setupObserver()
        return binding.root
    }

    private fun startupInitializer() {
        binding = ForgotPasswordFragmentBinding.inflate(layoutInflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnForgotActivityNext.setOnClickListener {

            val phone = binding.edtForgotActivityPhoneNumber.editText?.text.toString()
            val email = binding.edtForgotActivityEmail.editText?.text.toString()

            if (phone.isNotEmpty() && email.isNotEmpty()) {
                setupApiCall(phone, email)
            } else {
                showToast(getString(R.string.please_fill_all_the_fields))
            }
        }
    }
    private fun setupApiCall(phone:String,email:String){

        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN

        val params = JsonObject()
        params.addProperty(Keys.MOBILE_NUMBER, phone)

        params.addProperty(Keys.EMAIL, email)
        viewModel.getForgotPassword(OderPostModel(header, params))
    }
    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.forgetPasswordFlow.collect {
                    when (it) {
                        is Result.Error -> {
                            showToast(it.message)
                        }
                        is Result.Loading -> {}
                        is Result.Success -> {
                            if (it.body?.data?.success == true && it.body.data.first_try) {
                                showToast(getString(R.string.otp_successfully_send_your_mobile))
                                navController.navigate(
                                    ForgotPasswordFragmentDirections
                                        .actionForgotPasswordFragmentToOTPFragment(binding.edtForgotActivityPhoneNumber.editText?.text.toString())
                                )
                            } else if (it.body?.data?.success == true && !it.body.data.first_try) {
                                showToast(getString(R.string.please_enter_previously_send_otp))
                                navController.navigate(
                                    ForgotPasswordFragmentDirections
                                        .actionForgotPasswordFragmentToOTPFragment(binding.edtForgotActivityPhoneNumber.editText?.text.toString())
                                )

                            } else {
                                showToast(Constants.NETWORK_ERROR)
                            }
                        }
                    }
                }
            }
        }
    }
}