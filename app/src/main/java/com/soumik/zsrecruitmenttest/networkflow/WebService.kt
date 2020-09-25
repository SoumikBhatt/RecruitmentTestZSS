package com.soumik.zsrecruitmenttest.networkflow

import com.soumik.zsrecruitmenttest.data.models.DashboardResponse
import com.soumik.zsrecruitmenttest.data.models.LoginBody
import com.soumik.zsrecruitmenttest.data.models.ResponseLogin
import retrofit2.Response
import retrofit2.http.*


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
interface WebService {

   @POST("user")
   suspend fun login(@Body loginBody: LoginBody):Response<ResponseLogin>

    @GET("RecruitmentTest.json")
    suspend fun dashboard():Response<DashboardResponse>
}