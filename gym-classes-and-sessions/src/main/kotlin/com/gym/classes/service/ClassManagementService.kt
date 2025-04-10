package com.gym.classes.service

import com.gym.com.gym.classes.Repository.ClassManagementRepository
import com.gym.com.gym.classes.controller.dto.ClassDto
import com.gym.com.gym.classes.exception.FailedToCreateClassException
import com.gym.com.gym.classes.exception.FailedToFetchAllClassesException
import com.gym.com.gym.classes.exception.FailedToFetchClassDetailsException
import com.gym.com.gym.classes.model.GymClass
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClassManagementService(private val classRepository: ClassManagementRepository) {

    @Transactional
    fun createClass(classDto: ClassDto): ClassDto {
        try {
            val savedClass = classRepository.save(GymClass.createFrom(classDto))
            return ClassDto.createFrom(savedClass)

        } catch (ex: Exception) {
            throw FailedToCreateClassException()
        }
    }

    fun getAllClasses(): List<ClassDto> {
        try {
            val classes = classRepository.findAll()
            return classes.map { ClassDto.createFrom(it) }
        } catch (ex: Exception) {
            throw FailedToFetchAllClassesException()
        }
    }

    fun getClassDetails(id: String): ClassDto {
        try {
            val classModel = classRepository.findById(id).orElseThrow { FailedToFetchClassDetailsException(id)  }
            return ClassDto.createFrom(classModel)
        } catch (ex: FailedToFetchClassDetailsException) {
            throw FailedToFetchClassDetailsException(id)
        }
    }

}