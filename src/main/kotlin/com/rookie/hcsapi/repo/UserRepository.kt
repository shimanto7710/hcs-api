package com.rookie.hcsapi.repo



import com.rookie.hcsapi.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserModel, Long> {
}