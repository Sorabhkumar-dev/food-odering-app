package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.sorabh.grabfood.databinding.SignUpFragmentBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*

class SignUpFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding:SignUpFragmentBinding
    private val job = SupervisorJob()


    override fun onCreateView(
        inflater: android.view.LayoutInflater,
        container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View{
        binding = SignUpFragmentBinding.inflate(layoutInflater)

        navController = findNavController()
        //adding hint to editText
        binding.edtSignupUserName.hint = "Name"
        binding.edtSignupEmail.hint = "Email"
        binding.edtSignupPhoneNumber.hint = "Mobile"
        binding.edtSignupAddress.hint = "Delivery Address"
        binding.edtSignupPassword.hint = "Password"
        binding.edtSignupPasswordConfirm.hint = "Password Confirm"



        binding.btnSignup.setOnClickListener {

            //exacting values from editText
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

                CoroutineScope(job + Dispatchers.IO).launch {

                    //header to send with request
                    val header = HashMap<String, String>()
                    header["Content-type"] = "application/json"
                    header["token"] = "025c40375fadfd"

                    //params to send with request
                    val params = JsonObject()
                    params.addProperty("name", name)
                    params.addProperty("mobile_number", phone)
                    params.addProperty("password", password)
                    params.addProperty("address", address)
                    params.addProperty("email", email)

                    // creating repository instance
                    val repository = NetworkRepository()
                    try {

                        val signUpResponse = repository.getSignUpDetails(header, params)
                        Log.d("exc", signUpResponse.toString())
                        if (signUpResponse?.data?.success != false) {

                            showToast("You successfully SignUp!")
                            withContext(Dispatchers.Main) {
                                navController.navigate(
                                    SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                                )
                            }

                        } else {
                            showToast("Something Went Wrong!")
                        }

                    } catch (e: Exception) {
                        showToast("Failed to Connect Internet!")
                    }
                }

            } else {
                Toast.makeText(context, "Please Fill all the fields!", Toast.LENGTH_SHORT).show()
            }
        }

        //back to login activity
        binding.btnSignupBackToLogin.setOnClickListener {
            navController.navigate(
                SignUpFragmentDirections
                    .actionSignUpFragmentToLoginFragment()
            )
        }
        return binding.root
    }

    private suspend fun showToast(text: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }

    }
}