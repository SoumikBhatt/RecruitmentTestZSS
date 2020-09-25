package com.soumik.zsrecruitmenttest.viewmodel

import androidx.lifecycle.ViewModel
import com.soumik.zsrecruitmenttest.data.repositories.UserRepository


/**
 * Created by Soumik Bhattacharjee on 9/25/2020.
 * soumikcse07@gmail.com
 * http://soumikbhatt.github.io/
 */
class UserViewModel:ViewModel() {

    suspend fun loginUser(repository: UserRepository,email:String,password:String) = repository.loginUser(email, password)

    suspend fun dashDetails(repository: UserRepository) = repository.getDetails()
}