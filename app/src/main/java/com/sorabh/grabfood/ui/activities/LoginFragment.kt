package com.sorabh.grabfood.ui.activities

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.sorabh.grabfood.databinding.LoginFragmentBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*

class LoginFragment : Fragment() {
    private val job = SupervisorJob()
    lateinit var repository: NetworkRepository
    private lateinit var navController: NavController
   private lateinit var binding :LoginFragmentBinding

    private lateinit var loginSharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(inflater)
        //sharedPreference to store login credentials
        navController = findNavController()
        loginSharedPreferences = requireActivity().getSharedPreferences("login", MODE_PRIVATE)
        val isLogin = loginSharedPreferences.getBoolean("isLogin", false)
        if (isLogin) {
            navController.navigate(
                LoginFragmentDirections
                    .actionLoginFragmentToMainFragment()
            )
        }
        //repository
        repository = NetworkRepository()


        //adding hint to
        binding.edtLoginPhoneNumber.hint = "Mobile"
        binding.edtLoginPassword.hint = "Password"


        //adding clickListener to Login button
        binding.btnLogin.setOnClickListener {
            CoroutineScope(job + Dispatchers.IO).launch {

                val phone = binding.edtLoginPhoneNumber.editText?.text.toString()
                val password = binding.edtLoginPassword.editText?.text.toString()

                //params to send with request
                val params = JsonObject()
                params.addProperty("mobile_number", phone)
                params.addProperty("password", password)
                Log.d("exc", params.toString())


                //header to send
                val header = HashMap<String, String>()
                header["Content-type"] = "application/json"
                header["token"] = "025c40375fadfd"

                try {

                    val loginResponse = repository.getLoginDetails(header, params)
                    if (loginResponse != null) {
                        Log.d("exc", loginResponse.toString())
                    }
                    if (loginResponse?.data?.success == true) {
                        loginSharedPreferences.edit()
                            .putString("address", loginResponse.data.data.address)
                            .apply()
                        loginSharedPreferences.edit()
                            .putString("email", loginResponse.data.data.email)
                            .apply()
                        loginSharedPreferences.edit()
                            .putString("mobile_number", loginResponse.data.data.mobile_number)
                            .apply()
                        loginSharedPreferences.edit()
                            .putString("name", loginResponse.data.data.name)
                            .apply()
                        loginSharedPreferences.edit()
                            .putString("user_id", loginResponse.data.data.user_id)
                            .apply()
                        loginSharedPreferences.edit().putBoolean("isLogin", true).apply()
                        loginSharedPreferences.edit().apply()
                        withContext(job + Dispatchers.Main) {
                            navController.navigate(
                                LoginFragmentDirections
                                    .actionLoginFragmentToMainFragment()
                            )
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                "Please Enter Right Login Information!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: Exception) {
                    Log.d("exc", e.message.toString())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "Unable to connect internet!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        binding.btnLoginSignup.setOnClickListener {
            navController.navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
        binding.btnLoginForgotPassword.setOnClickListener {
           navController.navigate(
               LoginFragmentDirections
                   .actionLoginFragmentToForgotPasswordFragment()
           )
        }
        return binding.root
    }
}