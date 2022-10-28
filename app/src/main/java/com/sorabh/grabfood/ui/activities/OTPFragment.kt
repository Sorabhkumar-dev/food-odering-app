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
import androidx.navigation.fragment.navArgs
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.OtpFragmentBinding
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.OtpViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class OTPFragment : BaseFragment() {
    private val viewModel: OtpViewModel by viewModels()
    private val args: OTPFragmentArgs by navArgs()
    private lateinit var binding: OtpFragmentBinding
    private lateinit var navController: NavController

    @Inject
    lateinit var repository: NetworkRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer(inflater)
        setOnClickListener()
        setupObserver()
        return binding.root
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = OtpFragmentBinding.inflate(inflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnOtpResetPassword.setOnClickListener {
            val otp = binding.edtOtpActivityOtp.editText?.text.toString()
            val password = binding.edtOtpActivityPassword.editText?.text.toString()
            val confirmPassword = binding.edtOtpActivityConfirmPassword.editText?.text.toString()
            setupApiCall(args.phoneNo, otp, password, confirmPassword)
        }
    }

    private fun setupApiCall(
        phone: String,
        otp: String,
        password: String,
        confirmPassword: String
    ) {
        if (otp.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && password == confirmPassword) {
            val header = HashMap<String, String>()
            header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
            header[Keys.TOKEN] = Constants.MAIN_TOKEN

            val params = JsonObject()
            params.addProperty(Keys.MOBILE_NUMBER, phone)
            params.addProperty(Keys.PASSWORD, password)
            params.addProperty(Keys.OTP, otp)
            viewModel.getOtp(OderPostModel(header, params))
        } else {
            showToast(getString(R.string.please_fill_all_the_fields))
        }
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.otpFlow.collect {
                    when (it) {
                        is Result.Error -> {}
                        is Result.Loading -> {}
                        is Result.Success -> {
                            if (it.body?.data?.success == true) {
                                navController.navigate(
                                    OTPFragmentDirections
                                        .actionOTPFragmentToLoginFragment()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}