package com.gym.classes.service

import com.gym.com.gym.classes.Repository.ClassManagementRepository
import com.gym.com.gym.classes.controller.dto.ClassDto
import com.gym.com.gym.classes.exception.FailedToCreateClassException
import com.gym.com.gym.classes.model.SessionClass
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClassManagementService(private val classRepository: ClassManagementRepository) {

    @Transactional
    fun createClass(classDto: ClassDto): ClassDto {
        try {
            classRepository.save(SessionClass.createFrom(classDto))
            return classDto

        } catch (ex: Exception) {
            throw FailedToCreateClassException()
        }
    }

}