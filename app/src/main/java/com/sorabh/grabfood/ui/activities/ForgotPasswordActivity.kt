package com.sorabh.grabfood.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ActivityForgotPasswordBinding
import com.sorabh.grabfood.domain.repository.NetworkRepository
import kotlinx.coroutines.*

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var forgotPasswordBinding: ActivityForgotPasswordBinding
    private val job = SupervisorJob()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forgotPasswordBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_forgot_password)

        //adding hint to editText
        forgotPasswordBinding.edtForgotActivityEmail.hint = "Email"
        forgotPasswordBinding.edtForgotActivityPhoneNumber.hint = "Mobile"



        forgotPasswordBinding.btnForgotActivityNext.setOnClickListener {

            val phone = forgotPasswordBinding.edtForgotActivityPhoneNumber.editText?.text.toString()
            val email = forgotPasswordBinding.edtForgotActivityEmail.editText?.text.toString()

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
                            goDestination(this@ForgotPasswordActivity,phone)
                        } else if (forgotResponse?.success == true && !forgotResponse.first_try) {
                            showToast("Please enter previously send OTP!")
                            goDestination(this@ForgotPasswordActivity,phone)

                        } else {
                            showToast("Something went wrong!")
                        }

                    } catch (e: Exception) {
                        showToast("Failed to connect Internet!")
                    }

                }

            } else {
                Toast.makeText(this, "Please Enter all the fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private suspend fun showToast(text: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(this@ForgotPasswordActivity, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun goDestination(context: Context,phone:String=""){
        val intent = Intent(context,OTPActivity::class.java)
        intent.putExtra("phone",phone)
        startActivity(intent)
    }
}