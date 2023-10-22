package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.sorabh.grabfood.databinding.SignUpFragmentBinding
import com.sorabh.grabfood.domain.model.post.OderPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.SignUpViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class SignUpFragment : BaseFragment() {

    private val viewModel :SignUpViewModel by viewModels()

    private lateinit var navController: NavController
    private lateinit var binding:SignUpFragmentBinding


    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View{
        startupInitializer()
        setOnClickListener()
        setupObserver()
        return binding.root
    }

    private fun startupInitializer() {
        binding = SignUpFragmentBinding.inflate(layoutInflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnSignup.setOnClickListener {
            val name = binding.edtSignupUserName.editText?.text.toString()
            val phone = binding.edtSignupPhoneNumber.editText?.text.toString()
            val email = binding.edtSignupEmail.editText?.text.toString()
            val address = binding.edtSignupAddress.editText?.text.toString()
            val password = binding.edtSignupPassword.editText?.text.toString()
            val confirmPassword = binding.edtSignupPasswordConfirm.editText?.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
                && confirmPassword.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()
                && password == confirmPassword
            ) {
                    //header to send with request
                    val header = HashMap<String, String>()
                    header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
                    header[Keys.TOKEN] = Constants.MAIN_TOKEN

                    //params to send with request
                    val params = JsonObject()
                    params.addProperty(Keys.NAME, name)
                    params.addProperty(Keys.MOBILE_NUMBER, phone)
                    params.addProperty(Keys.PASSWORD, password)
                    params.addProperty(Keys.Address, address)
                    params.addProperty(Keys.EMAIL, email)
                    viewModel.getSignUpData(OderPostModel(header, params)){}
            } else {
                showToast("Please Fill all the fields!")
            }
        }
        binding.btnSignupBackToLogin.setOnClickListener {
            navController.navigate(
                SignUpFragmentDirections
                    .actionSignUpFragmentToLoginFragment()
            )
        }
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.signUpFlow.collect {
                    when (it) {
                        is Result.Error -> showToast(it.message)
                        is Result.Loading -> {}
                        is Result.Success -> {
                            showToast("You successfully SignUp!")
                            withContext(Dispatchers.Main) {
                                navController.navigate(
                                    SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}