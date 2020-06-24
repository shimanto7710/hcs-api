package com.rookie.hcsapi.data_handler


import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.model.Banner
import com.rookie.hcsapi.model.ServiceModel
import com.rookie.hcsapi.model.UserModel
import java.util.*


interface DataHandlerInterface {

     public fun sendOtp(phoneNumber: String): Response?

     public fun getAllUser():List<UserModel>?

     public fun getUserById(id:Long) :  Optional<UserModel>?

     public fun createUser(userModel: UserModel) : UserModel?

     public fun removeUser(id:Long) : Unit?


     fun findAllService():List<ServiceModel>?

     fun findServiceById(id:Long): Optional<ServiceModel>?

     fun createService(serviceModel: ServiceModel) : ServiceModel?


}
