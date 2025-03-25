package com.gym.staff.repository

import com.gym.staff.model.Staff
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StaffRepository: JpaRepository<Staff, String> {


}