package com.rookie.hcsapi.data_handler


import com.rookie.hcsapi.core.Response


interface DataHandlerInterface {

     public fun sendOtp(phoneNumber: String): Response?

}
