package com.sorabh.grabfood.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.gson.JsonObject
import com.sorabh.grabfood.R
import com.sorabh.grabfood.databinding.ActivityLoginBinding
import com.sorabh.grabfood.repository.NetworkRepository
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {
    private val job = SupervisorJob()
    lateinit var repository: NetworkRepository

    lateinit var loginBinding: ActivityLoginBinding

    private lateinit var loginSharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        //sharedPreference to store login credentials
        loginSharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
        val isLogin = loginSharedPreferences.getBoolean("isLogin", false)
        if (isLogin) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        //repository
        repository = NetworkRepository()


        //adding hint to
        loginBinding.edtLoginPhoneNumber.hint = "Mobile"
        loginBinding.edtLoginPassword.hint = "Password"


        //adding clickListener to Login button
        loginBinding.btnLogin.setOnClickListener {
            CoroutineScope(job + Dispatchers.IO).launch {

                val phone = loginBinding.edtLoginPhoneNumber.editText?.text.toString()
                val password = loginBinding.edtLoginPassword.editText?.text.toString()

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
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                this@LoginActivity,
                                "Please Enter Right Login Information!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: Exception) {
                    Log.d("exc", e.message.toString())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            "Unable to connect internet!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
        loginBinding.btnLoginSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        loginBinding.btnLoginForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}