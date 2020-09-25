package com.soumik.zsrecruitmenttest.utils


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
data class Resource<T> (val status: Status,val data:T?,val error:String?){

    companion object {

        fun <T> success(data:T):Resource<T> {
            return Resource(Status.SUCCESS,data,null)
        }

        fun <T> error(message:String?):Resource<T> {
            return Resource(Status.ERROR,null,message)
        }

        fun <T> loading():Resource<T> = Resource(Status.LOADING,null,null)
    }
}