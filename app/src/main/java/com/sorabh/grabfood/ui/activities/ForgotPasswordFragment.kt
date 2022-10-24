package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import com.sorabh.grabfood.databinding.ForgotPasswordFragmentBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import kotlinx.coroutines.*

class ForgotPasswordFragment : BaseFragment() {
    private lateinit var binding:ForgotPasswordFragmentBinding
    private lateinit var navController: NavController
    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =ForgotPasswordFragmentBinding.inflate(layoutInflater)
        navController = findNavController()
        //adding hint to editText
        binding.edtForgotActivityEmail.hint = "Email"
        binding.edtForgotActivityPhoneNumber.hint = "Mobile"



        binding.btnForgotActivityNext.setOnClickListener {

            val phone = binding.edtForgotActivityPhoneNumber.editText?.text.toString()
            val email = binding.edtForgotActivityEmail.editText?.text.toString()

            if (phone.isNotEmpty() && email.isNotEmpty()) {
                CoroutineScope(job + Dispatchers.IO).launch {

                    //header to send with request
                    val header = HashMap<String, String>()
                    header["Content-type"] = "application/json"
                    header["token"] = "025c40375fadfd"

                    //params to send with request
                    val params = JsonObject()
                    params.addProperty("mobile_number", phone)
                    params.addProperty("email", email)

                    // creating repository object
                    val repository = NetworkRepository()

                    try {
                        //making api call
                        val forgotResponse = repository.getForgotResponse(header, params)
                        Log.d("exc1",forgotResponse.toString())

                        if (forgotResponse?.success == true && forgotResponse.first_try) {
                            showToast("OTP successfully send your mobile!")
                            navController.navigate(
                                ForgotPasswordFragmentDirections
                                    .actionForgotPasswordFragmentToOTPFragment(phone)
                            )

                        } else if (forgotResponse?.success == true && !forgotResponse.first_try) {
                            showToast("Please enter previously send OTP!")
                            navController.navigate(
                                ForgotPasswordFragmentDirections
                                    .actionForgotPasswordFragmentToOTPFragment(phone)
                            )

                        } else {
                            showToast("Something went wrong!")
                        }

                    } catch (e: Exception) {
                        showToast("Failed to connect Internet!")
                    }

                }

            } else {
                Toast.makeText(requireContext(), "Please Enter all the fields!", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

    private suspend fun showToast(text: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
        }
    }
}