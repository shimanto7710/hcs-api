package com.rookie.hcsapi.data_handler


import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.model.Banner
import com.rookie.hcsapi.model.User
import java.util.*


interface DataHandlerInterface {

     public fun sendOtp(phoneNumber: String): Response?

     public fun getAllUser():List<User>?

     public fun getUserById(id:Long) :  Optional<User>?

     public fun createUser(user: User) : User?

     public fun removeUser(id:Long) : Unit?

     fun getAllBanner():MutableList<Banner>?


}
