package com.rookie.hcsapi.controller

import com.rookie.hcsapi.auth.AuthRequestBody
import com.rookie.hcsapi.core.LoginSuccessBody
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.data_handler.DataHandlerInterface
import com.rookie.hcsapi.model.Banner
import com.rookie.hcsapi.model.User
import com.rookie.hcsapi.repo.UserRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

import java.util.*

@Service
class ControllerService : DataHandlerInterface {

    private var dataHandler: DataHandlerInterface? = null

    @Autowired
    fun authServices(@Qualifier("realData") dataHandler: DataHandlerInterface?) {
        this.dataHandler = dataHandler
    }

    @Autowired
    private var userRepository: UserRepository? = null


    override fun sendOtp(phoneNumber: String): Response? {
        return Response(true, "5544")
    }

    override fun getAllUser(): List<User>? {
        return dataHandler?.getAllUser()
    }

    override fun getUserById(id: Long): Optional<User>? {
        return dataHandler?.getUserById(id)
    }

    override fun createUser(user: User): User? {
        return dataHandler?.createUser(user)
    }

    override fun removeUser(id: Long): Unit? {
        return dataHandler?.removeUser(id)
    }

    override fun getAllBanner(): MutableList<Banner>? {
        return dataHandler?.getAllBanner()
    }


    fun login(authRequestBody: AuthRequestBody): LoginSuccessBody? {
        var userModel = userRepository?.findByPhoneNumber(authRequestBody.username)
        if (userModel==null){
            userModel=userRepository?.save(User(-10,null,authRequestBody.username,null,null,"xyz10",null))
        }
        return LoginSuccessBody(userModel)
    }


}