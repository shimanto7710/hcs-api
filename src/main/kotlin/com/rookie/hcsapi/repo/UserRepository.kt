package com.rookie.hcsapi.repo



import com.rookie.hcsapi.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository: JpaRepository<UserModel, Long> {

    @Query(value = "SELECT * FROM user where phone_number = ?1", nativeQuery = true)
    fun findByPhoneNumber(phoneNumber: String?): UserModel?
}