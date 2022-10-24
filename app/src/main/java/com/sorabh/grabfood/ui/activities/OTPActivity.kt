package com.sorabh.grabfood.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ActivityOtpActivityBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*

class OTPActivity : AppCompatActivity() {
    lateinit var otpBinding: ActivityOtpActivityBinding
    private val job = SupervisorJob()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        otpBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp_activity)

        //adding hint to editText
        otpBinding.edtOtpActivityOtp.hint = "OTP"
        otpBinding.edtOtpActivityPassword.hint = "Password"
        otpBinding.edtOtpActivityConfirmPassword.hint = "Password Confirm"

        otpBinding.btnOtpResetPassword.setOnClickListener {
            val otp = otpBinding.edtOtpActivityOtp.editText?.text.toString()
            val password = otpBinding.edtOtpActivityPassword.editText?.text.toString()
            val passwordConfirm = otpBinding.edtOtpActivityConfirmPassword.editText?.text.toString()
            if (otp.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty() && password == passwordConfirm) {
                CoroutineScope(job + Dispatchers.IO).launch {

                    //header to send with request
                    val header = HashMap<String, String>()
                    header["Content-type"] = "application/json"
                    header["token"] = "025c40375fadfd"

                    val phone = intent.getStringExtra("phone")
                    Log.d("exccc",phone.toString())

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
                                val intent = Intent(this@OTPActivity,LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@OTPActivity,
                                    "Sorry, Something went wrong",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    } catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@OTPActivity,
                                "Failed To connect to internet!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please Enter all the fields!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}