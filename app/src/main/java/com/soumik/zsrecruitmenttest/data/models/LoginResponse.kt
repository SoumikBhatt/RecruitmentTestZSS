package com.soumik.zsrecruitmenttest.data.models

import com.google.gson.annotations.SerializedName


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

data class LoginResponse(
    @SerializedName("action")
    var action:String="",
    @SerializedName("message")
    var message:String="",
    @SerializedName("dataArray")
    var dataArray:List<DataArray>,
    @SerializedName("userid")
    var userid:Int?=null,
    @SerializedName("reason")
    var reason:String?=null
)

data class DataArray(
    @SerializedName("userid")
    var userid:Int?=null,
    @SerializedName("email")
    var email:String?=null,
    @SerializedName("contact")
    var contact:String?=null,
    @SerializedName("firstname")
    var fName:String?=null,
    @SerializedName("surname")
    var surName:String?=null,
    @SerializedName("companyname")
    var companyName:String?=null
)
data class LL(
    @SerializedName("action")
    val action: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("reason")
    val reason: String
)