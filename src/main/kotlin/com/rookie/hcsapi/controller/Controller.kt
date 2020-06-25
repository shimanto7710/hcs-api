package com.rookie.hcsapi.controller

import com.rookie.hcsapi.auth.AuthRequestBody
import com.rookie.hcsapi.auth.JwtUtil
import com.rookie.hcsapi.auth.MyUserDetailsService
import com.rookie.hcsapi.core.LoginSuccessBody
import com.rookie.hcsapi.core.Response
import com.rookie.hcsapi.data_handler.DataHandlerInterface
import com.rookie.hcsapi.model.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/")
class Controller : DataHandlerInterface {

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtTokenUtil: JwtUtil? = null
    @Autowired
    private val userDetailsService: MyUserDetailsService? = null

    @Autowired
    private val controllerService: ControllerService? = null




//    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
//    @Throws(Exception::class)
//    fun createAuthenticationToken(@RequestBody authenticationRequest: AuthRequestBody): ResponseEntity<*> {
//        try {
//            authenticationManager!!.authenticate(
//                    UsernamePasswordAuthenticationToken(authenticationRequest.username, authenticationRequest.password)
//            )
//        } catch (e: BadCredentialsException) {
//            throw Exception("Incorrect username or password", e)
//        }
//        val userDetails = authenticationRequest.username?.let {
//            userDetailsService
//                    ?.loadUserByUsername(it)
//
//        }
//
//        val jwt = userDetails?.let { jwtTokenUtil!!.generateToken(it) }
//        print(jwt)
//        return jwt?.let { AuthenticationResponse(it) }?.let { ResponseEntity.ok(it) }!!
//    }

    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: AuthRequestBody): String? {
        println(authenticationRequest)
        try {
            authenticationManager!!.authenticate(
                    UsernamePasswordAuthenticationToken(authenticationRequest.username, authenticationRequest.password)
            )
        } catch (e: BadCredentialsException) {
            throw Exception("Incorrect username or password", e)
        }
        val userDetails = authenticationRequest.username?.let {
            userDetailsService
                    ?.loadUserByUsername(it)

        }

        val jwt = userDetails?.let { jwtTokenUtil!!.generateToken(it) }
        println(jwt)
        return jwt
    }

    @GetMapping(value = ["/hello"])
    fun hello():String{
        return "Welcome to hcs project"
    }

    @GetMapping(value=["/send-otp/{phoneNumber}"])
    override fun sendOtp(@PathVariable("phoneNumber") phoneNumber :String) : Response?{
        return controllerService?.sendOtp(phoneNumber)
    }

    @GetMapping(value=["/users"])
    override fun getAllUser(): List<UserModel>? {
        return controllerService?.getAllUser()
    }

    @GetMapping(value=["/users/{id}"])
    override fun getUserById(@PathVariable("id") id: Long): Optional<UserModel>? {
        return controllerService?.getUserById(id)
    }
    @PostMapping(value=["/create-users"])
    override fun createUser(@RequestBody userModel: UserModel): UserModel? {
        return controllerService?.createUser(userModel)
    }

    @GetMapping(value=["/remove-users/{id}"])
    override fun removeUser(@PathVariable("id") id: Long): Unit? {
        return controllerService?.removeUser(id)
    }

    @GetMapping(value = ["/services"])
    override fun findAllService(): List<ServiceModel>? {
        return controllerService?.findAllService()
    }

    @GetMapping(value = ["/services/{id}"])
    override fun findServiceById(@PathVariable("id") id: Long): Optional<ServiceModel>? {
        return controllerService?.findServiceById(id)
    }

    @PostMapping(value = ["/create-services"])
    override fun createService(@RequestBody serviceModel: ServiceModel): ServiceModel? {
//        print(serviceModel)
        return controllerService?.createService(serviceModel)
    }

    @GetMapping(value = ["/remove-services/{id}"])
    override fun removeService(@PathVariable("id") id: Long): Unit? {
        return controllerService?.removeService(id)
    }

    @GetMapping(value = ["/promos"])
    override fun findAllPromo(): List<PromoModel>? {
        return controllerService?.findAllPromo()
    }

    @GetMapping(value = ["/promos/{id}"])
    override fun findPromoById(@PathVariable("id") id: Long): Optional<PromoModel>? {
        return controllerService?.findPromoById(id)
    }

    @PostMapping(value = ["/create-promos"])
    override fun createPromo(@RequestBody promoModel: PromoModel): PromoModel? {
        print(promoModel)
        return controllerService?.createPromo(promoModel)
    }

    @GetMapping(value = ["/remove-promos/{id}"])
    override fun removePromoById(@PathVariable("id") id: Long): Unit? {
        return controllerService?.removePromoById(id)
    }

    @PostMapping(value=["/login/"])
    fun login(@RequestBody authenticationRequest: AuthRequestBody) :LoginSuccessBody? {
        return controllerService?.login(authenticationRequest)
    }

    @GetMapping(value = ["/tasks"])
    override fun findAllTask(): List<TaskModel>? {
        return controllerService?.findAllTask()
    }

    @GetMapping(value = ["/tasks/{id}"])
    override fun findTaskById(@PathVariable("id") id: Long): Optional<TaskModel>? {
        return controllerService?.findTaskById(id)
    }

    @PostMapping(value = ["/create-tasks"])
    override fun createTask(@RequestBody taskModel: TaskModel): TaskModel? {
        return controllerService?.createTask(taskModel)
    }

    @GetMapping(value = ["/remove-task/{id}"])
    override fun removeTaskById(@PathVariable("id") id: Long): Unit? {
        return controllerService?.removeTaskById(id)
    }


}