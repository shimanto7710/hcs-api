package com.rookie.hcsapi.controller

import com.rookie.hcsapi.auth.AuthRequestBody
import com.rookie.hcsapi.core.LoginSuccessBody
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.data_handler.DataHandlerInterface
import com.rookie.hcsapi.model.UserModel
import com.rookie.hcsapi.repo.UserRepository
import net.minidev.json.JSONArray

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

    override fun getAllUser(): List<UserModel>? {
        return dataHandler?.getAllUser()
    }

    override fun getUserById(id: Long): Optional<UserModel>? {
        return dataHandler?.getUserById(id)
    }

    override fun createUser(userModel: UserModel): UserModel? {
        return dataHandler?.createUser(userModel)
    }

    override fun removeUser(id: Long): Unit? {
        return dataHandler?.removeUser(id)
    }

    override fun getAllBook(): JSONArray? {
        return dataHandler?.getAllBook()
    }

    fun login(authRequestBody: AuthRequestBody): LoginSuccessBody? {
        var userModel = userRepository?.findByPhoneNumber(authRequestBody.username)
        if (userModel==null){
            userModel=userRepository?.save(UserModel(-10,null,authRequestBody.username,null,null,"xyz10",null))
        }
        return LoginSuccessBody(userModel)
    }


}