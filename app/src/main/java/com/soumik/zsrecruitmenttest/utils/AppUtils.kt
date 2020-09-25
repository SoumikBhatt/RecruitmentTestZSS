package com.soumik.zsrecruitmenttest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */

//method for showing toast message
fun showToast(context: Context,message:String) = Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

fun isNetworkActive(context: Context):Boolean{
    val isConnected:Boolean
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo

    isConnected = activeNetwork !=null
    return isConnected
}