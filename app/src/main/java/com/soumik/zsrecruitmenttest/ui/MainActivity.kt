package com.soumik.zsrecruitmenttest.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.soumik.zsrecruitmenttest.R
import com.soumik.zsrecruitmenttest.data.repositories.UserRepository
import com.soumik.zsrecruitmenttest.utils.Status
import com.soumik.zsrecruitmenttest.utils.isNetworkActive
import com.soumik.zsrecruitmenttest.utils.showToast
import com.soumik.zsrecruitmenttest.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    private lateinit var viewModel:UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    fun onLoginClicked(view: View) {

        when {
            TextUtils.isEmpty(et_user_name.text.toString()) -> et_user_name.error = "Please provide your username"
            TextUtils.isEmpty(et_user_password.text.toString()) -> et_user_password.error = "Please provide your password"
            else -> if (isNetworkActive(this@MainActivity)) doLogin(et_user_name.text.toString(),et_user_password.text.toString()) else showToast(this@MainActivity,"No network connection")
        }
    }

    private fun doLogin(name: String, password: String) {

        setUpObserver(name,password)

    }

    private fun setUpObserver(name: String,password: String) {

        lifecycleScope.launch {
            viewModel.loginUser(UserRepository(),name,password).observe(this@MainActivity,{
                it.let {resource ->
                    when(resource.status){
                        Status.SUCCESS->{
                            if (it.data?.message=="Successful") navigateToNext()
                            else showToast(this@MainActivity,it.data?.reason!!)
                        }
                        Status.ERROR->{
                            showToast(this@MainActivity,"Something went wrong! Try Again")
                        }
                        Status.LOADING -> Log.d(TAG,"Loading...")
                    }
                }
            })
        }
    }

    private fun navigateToNext() {
        Log.d(TAG,"Success")
        startActivity(Intent(this@MainActivity,NextActivity::class.java))
        finish()
    }
}