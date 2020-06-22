package com.rookie.hcsapi.data_handler
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.model.UserModel
import com.rookie.hcsapi.repo.UserRepository
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository("realData")
class RealData : DataHandlerInterface {

    @Autowired
    var userRepository: UserRepository? = null


    override fun sendOtp(phoneNumber: String): Response? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllUser(): List<UserModel>? {
        return userRepository?.findAll()
    }

    override fun getUserById(id:Long): Optional<UserModel>? {
        return userRepository?.findById(id)
    }

    override fun createUser(userModel: UserModel): UserModel? {
        return userRepository?.save(userModel)

    }

    override fun removeUser(id: Long): Unit? {
        return userRepository?.deleteById(id)
    }




}