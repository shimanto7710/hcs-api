package com.rookie.hcsapi.repo

import com.rookie.hcsapi.model.ServiceModel
import com.rookie.hcsapi.model.TaskModel
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepo : JpaRepository<TaskModel, Long> {
}