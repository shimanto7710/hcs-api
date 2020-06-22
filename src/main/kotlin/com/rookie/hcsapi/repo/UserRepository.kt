package com.rookie.hcsapi.repo

import com.rookie.hcsapi.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user where phone_number = ?1", nativeQuery = true)
    fun findByPhoneNumber(phoneNumber: String?): User?
}