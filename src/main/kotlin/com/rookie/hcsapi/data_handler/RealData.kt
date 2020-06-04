package com.rookie.hcsapi.data_handler



import com.rookie.hcsapi.core.Response
import org.springframework.stereotype.Repository

@Repository("realData")
class RealData : DataHandlerInterface {
    override fun sendOtp(phoneNumber: String): Response? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}