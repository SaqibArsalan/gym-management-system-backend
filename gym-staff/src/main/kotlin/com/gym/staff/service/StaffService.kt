package com.gym.staff.service

import com.gym.com.gym.staff.controller.dto.CreateOrUpdateStaffDto
import com.gym.com.gym.staff.controller.dto.StaffResponseDto
import com.gym.staff.model.Staff
import com.gym.staff.repository.StaffRepository
import org.springframework.stereotype.Service

@Service
class StaffService(private val staffRepository: StaffRepository) {

    fun createStaff(addOrUpdateStaff: CreateOrUpdateStaffDto): StaffResponseDto {
        val staffModel = Staff.createFrom(addOrUpdateStaff)
        val savedStaff = staffRepository.save(staffModel)
        return StaffResponseDto.createFrom(savedStaff)
    }
}