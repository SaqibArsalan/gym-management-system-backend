package com.gym.com.gym.classes.Repository

import com.gym.com.gym.classes.model.GymClass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassManagementRepository: JpaRepository<GymClass, String> {
}