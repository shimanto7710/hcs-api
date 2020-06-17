package com.rookie.hcsapi.data_handler
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.model.UserModel

import org.springframework.stereotype.Repository
import java.util.*

@Repository("fakeData")
class FakeData : DataHandlerInterface {
    override fun sendOtp(phoneNumber: String): Response? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllUser(): List<UserModel>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserById(id: Long): Optional<UserModel>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(userModel: UserModel): UserModel? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeUser(id: Long): Unit? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}