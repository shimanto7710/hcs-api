package com.rookie.hcsapi.controller
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.data_handler.DataHandlerInterface
import com.rookie.hcsapi.model.UserModel

import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
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

    override fun sendOtp(phoneNumber: String): Response? {
        return Response(true,"5544")
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


}