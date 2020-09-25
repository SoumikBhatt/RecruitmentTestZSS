package com.soumik.zsrecruitmenttest.networkflow

import com.soumik.zsrecruitmenttest.utils.BASE_URL
import com.soumik.zsrecruitmenttest.utils.BASE_URL_LOGIN
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class RetrofitClient {

    companion object {

        private val client: OkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor { it.proceed(it.request().newBuilder().build()) }.build()


        private val retrofit : Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL_LOGIN)
//            .client(client)
            .build()

        private val retrofit2 :Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val webService: WebService = retrofit.create(WebService::class.java)
        val webService2: WebService = retrofit2.create(WebService::class.java)

    }
}