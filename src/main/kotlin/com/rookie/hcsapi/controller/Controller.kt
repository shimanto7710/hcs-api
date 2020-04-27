package com.rookie.hcsapi.controller

import com.rookie.hcsapi.auth.AuthRequestBody
import com.rookie.hcsapi.auth.AuthenticationResponse
import com.rookie.hcsapi.auth.JwtUtil
import com.rookie.hcsapi.auth.MyUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/")
class Controller {

    @Autowired
    private val authenticationManager: AuthenticationManager? = null
    @Autowired
    private val jwtTokenUtil: JwtUtil? = null
    @Autowired
    private val userDetailsService: MyUserDetailsService? = null

//    @Autowired
//    private val controllerService: ControllerService? = null


    @RequestMapping(value = ["/authenticate"], method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationRequest: AuthRequestBody): ResponseEntity<*> {
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
        return jwt?.let { AuthenticationResponse(it) }?.let { ResponseEntity.ok(it) }!!
    }

    @GetMapping(value = ["/hello"])
    fun hello():String{
        return "Welcome to hcs project"
    }


}