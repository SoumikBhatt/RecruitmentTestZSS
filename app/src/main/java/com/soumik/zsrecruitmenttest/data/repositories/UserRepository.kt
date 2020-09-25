package com.soumik.zsrecruitmenttest.data.repositories

import android.util.Log
import androidx.constraintlayout.solver.GoalRow
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.soumik.zsrecruitmenttest.data.models.DashboardResponse
import com.soumik.zsrecruitmenttest.data.models.LoginBody
import com.soumik.zsrecruitmenttest.data.models.ResponseLogin
import com.soumik.zsrecruitmenttest.data.models.Resources
import com.soumik.zsrecruitmenttest.networkflow.RetrofitClient
import com.soumik.zsrecruitmenttest.utils.Resource
import java.io.IOException


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class UserRepository {

    suspend fun loginUser(email:String,password:String) : LiveData<Resource<ResponseLogin>>{

        val data = MutableLiveData<Resource<ResponseLogin>>()
        val loginBody = LoginBody()
        loginBody.email = email
        loginBody.password = password

        try {
            val response = RetrofitClient.webService.login(loginBody)
            Log.d("ResponseLogin","Code: ${response.code()} Body: ${Gson().toJson(response.body())}")
            if (response.isSuccessful) data.postValue(Resource.success(response.body()!!))
            else data.postValue(Resource.error("Unsuccessful Response code: ${response.code()}"))
        } catch (t:Throwable){
            Log.e("ResponseLogin","Error: ${t.localizedMessage}")
            when(t){
                is IOException -> data.postValue(Resource.error("Network Failure"))
                else -> data.postValue(Resource.error(t.localizedMessage))
            }
        }

        return data
    }

    suspend fun getDetails():LiveData<Resource<DashboardResponse>> {

        val data = MutableLiveData<Resource<DashboardResponse>>()

        try {
            val response = RetrofitClient.webService2.dashboard()
            Log.d(
                "DashboardResponse",
                "Code: ${response.code()} Body: ${Gson().toJson(response.body())}"
            )
            if (response.body() != null) data.postValue(Resource.success(response.body()!!))
            else data.postValue(Resource.error("Null Response code: ${response.code()}"))
        } catch (t: Throwable) {
            Log.e("DashboardResponse", "Error: ${t.localizedMessage}")
            when (t) {
                is IOException -> data.postValue(Resource.error("Network Failure"))
                else -> data.postValue(Resource.error(t.localizedMessage))
            }
        }

        return data
    }
}