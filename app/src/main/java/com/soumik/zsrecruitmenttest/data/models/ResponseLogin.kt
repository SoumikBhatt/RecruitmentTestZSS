package com.soumik.zsrecruitmenttest.data.models
import com.google.gson.annotations.SerializedName



/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
data class ResponseLogin(
    @SerializedName("action")
    val action: String,
    @SerializedName("dataArray")
    val dataArray: List<DataArrayLL>,
    @SerializedName("message")
    val message: String,
    @SerializedName("userid")
    val userid: Int?,
    @SerializedName("reason")
    var reason:String?
)

data class DataArrayLL(
    @SerializedName("companyname")
    val companyname: String,
    @SerializedName("contact")
    val contact: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("userid")
    val userid: Int
)