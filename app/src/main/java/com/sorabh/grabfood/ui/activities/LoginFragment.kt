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
import com.sorabh.grabfood.databinding.LoginFragmentBinding
import com.sorabh.grabfood.domain.model.login_respones.LoginResponse
import com.sorabh.grabfood.domain.model.post.LoginPostModel
import com.sorabh.grabfood.domain.network_api.Result
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import com.sorabh.grabfood.ui.viewmodel.LoginViewModel
import com.sorabh.grabfood.util.Constants
import com.sorabh.grabfood.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment() {
    @Inject
    lateinit var repository: NetworkRepository
    private lateinit var navController: NavController
    private lateinit var binding: LoginFragmentBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        startupInitializer(inflater)
        setupObserver()
        setOnClickListener()
        return binding.root
    }

    private fun startupInitializer(inflater: LayoutInflater) {
        binding = LoginFragmentBinding.inflate(inflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnLogin.setOnClickListener {
            setupLoginRequest()
        }
        binding.btnLoginSignup.setOnClickListener {
            navController.navigate(
                LoginFragmentDirections
                    .actionLoginFragmentToSignUpFragment()
            )
        }
        binding.btnLoginForgotPassword.setOnClickListener {
            navController.navigate(
                LoginFragmentDirections
                    .actionLoginFragmentToForgotPasswordFragment()
            )
        }
    }

    private fun setupLoginRequest() {
        //params to send with request
        val params = JsonObject()
        params.addProperty(
            Keys.MOBILE_NUMBER,
            binding.edtLoginPhoneNumber.editText?.text.toString()
        )
        params.addProperty(
            Keys.PASSWORD,
            binding.edtLoginPassword.editText?.text.toString()
        )

        //header to send
        val header = HashMap<String, String>()
        header[Keys.CONTENT_TYPE] = Constants.CONTENT_TYPE_VALUE
        header[Keys.TOKEN] = Constants.MAIN_TOKEN
        viewModel.getLoginDetails(LoginPostModel(header, params))
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    viewModel.loginFlow.collect {
                        when (it) {
                            is Result.Error -> {}
                            is Result.Loading -> {}
                            is Result.Success -> {
                                it.body?.let { data ->
                                    saveLoginData(data)
                                }
                            }
                        }
                    }
                }
                launch {
                    viewModel.isLoginFlow.collect {
                        if (it) redirectToMain()
                    }
                }
            }
        }
    }

    private fun redirectToMain() {
        navController.navigate(
            LoginFragmentDirections
                .actionLoginFragmentToMainFragment()
        )
    }

    private suspend fun saveLoginData(loginData: LoginResponse) {
        viewModel.writeName(loginData.data.data.name)
        viewModel.writeAddress(loginData.data.data.address)
        viewModel.writeEmail(loginData.data.data.email)
        viewModel.writeUserId(loginData.data.data.user_id)
        viewModel.writeMobileNumber(loginData.data.data.mobile_number)
        viewModel.writeIsLogin(true)
    }
}