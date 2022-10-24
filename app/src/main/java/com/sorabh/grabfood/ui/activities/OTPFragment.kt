package com.sorabh.grabfood.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.gson.JsonObject
import com.sorabh.grabfood.databinding.OtpFragmentBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import com.sorabh.grabfood.ui.fragments.home.BaseFragment
import kotlinx.coroutines.*

class OTPFragment : BaseFragment() {
    private lateinit var binding:OtpFragmentBinding
    private lateinit var navController: NavController
    private val args :OTPFragmentArgs by navArgs()
    private val job = SupervisorJob()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OtpFragmentBinding.inflate(inflater)
        navController = findNavController()
        //adding hint to editText
        binding.edtOtpActivityOtp.hint = "OTP"
        binding.edtOtpActivityPassword.hint = "Password"
        binding.edtOtpActivityConfirmPassword.hint = "Password Confirm"

        binding.btnOtpResetPassword.setOnClickListener {
            val otp = binding.edtOtpActivityOtp.editText?.text.toString()
            val password = binding.edtOtpActivityPassword.editText?.text.toString()
            val passwordConfirm = binding.edtOtpActivityConfirmPassword.editText?.text.toString()
            if (otp.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty() && password == passwordConfirm) {
                CoroutineScope(job + Dispatchers.IO).launch {

                    //header to send with request
                    val header = HashMap<String, String>()
                    header["Content-type"] = "application/json"
                    header["token"] = "025c40375fadfd"

                    val phone = args.phoneNo
                    Log.d("exccc", phone)

                    //params to send with request
                    val params = JsonObject()
                    params.addProperty("mobile_number", phone)
                    params.addProperty("password", password)
                    params.addProperty("otp", otp)

                    //creating repository object
                    val repository = NetworkRepository()
                    try {
                        val otpResponse = repository.getOTPResponse(header, params)
                        Log.d("otpinfo",otpResponse.toString())
                        withContext(job + Dispatchers.Main) {
                            if (otpResponse?.success == true) {
                                navController.navigate(
                                    OTPFragmentDirections
                                        .actionOTPFragmentToLoginFragment()
                                )
                            } else {
                                Toast.makeText(
                                    context,
                                    "Sorry, Something went wrong",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                "Failed To connect to internet!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(context, "Please Enter all the fields!", Toast.LENGTH_SHORT).show()
            }

        }
        return binding.root
    }
}