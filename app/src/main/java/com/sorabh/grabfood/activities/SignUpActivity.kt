package com.sorabh.grabfood.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ActivitySignUpBinding
import com.sorabh.grabfood.repository.NetworkRepository
import kotlinx.coroutines.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    private val job = SupervisorJob()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        //adding hint to editText
        signUpBinding.edtSignupUserName.hint = "Name"
        signUpBinding.edtSignupEmail.hint = "Email"
        signUpBinding.edtSignupPhoneNumber.hint = "Mobile"
        signUpBinding.edtSignupAddress.hint = "Delivery Address"
        signUpBinding.edtSignupPassword.hint = "Password"
        signUpBinding.edtSignupPasswordConfirm.hint = "Password Confirm"



        signUpBinding.btnSignup.setOnClickListener {

            //exacting values from editText
            val name = signUpBinding.edtSignupUserName.editText?.text.toString()
            val phone = signUpBinding.edtSignupPhoneNumber.editText?.text.toString()
            val email = signUpBinding.edtSignupEmail.editText?.text.toString()
            val address = signUpBinding.edtSignupAddress.editText?.text.toString()
            val password = signUpBinding.edtSignupPassword.editText?.text.toString()
            val confirmPassword = signUpBinding.edtSignupPasswordConfirm.editText?.text.toString()


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
                                val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                        } else {
                            showToast("Something Went Wrong!")
                        }

                    } catch (e: Exception) {
                        showToast("Failed to Connect Internet!")
                    }
                }

            } else {
                Toast.makeText(this, "Please Fill all the fields!", Toast.LENGTH_SHORT).show()
            }
        }

        //back to login activity
        signUpBinding.btnSignupBackToLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private suspend fun showToast(text: String) {
        withContext(Dispatchers.Main) {
            Toast.makeText(this@SignUpActivity, text, Toast.LENGTH_SHORT).show()
        }

    }
}