package com.gym.service

import com.gym.controller.dto.UserAddOrUpdateDto
import com.gym.controller.dto.UserInfoDto
import com.gym.exception.EmailAlreadyTakenException
import com.gym.exception.UserNotPresentException
import com.gym.model.User
import com.gym.repository.UserRepository
//import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsersService(private val userRepository: UserRepository)
//                   private val passwordEncoder: PasswordEncoder)
                   {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUser(userId: String): UserInfoDto {
        try {
            val user = userRepository.findById(userId)
            if (user.isPresent) {
                return user.get().toUserInfo()
            } else {
                throw UserNotPresentException(userId)
            }
        } catch (ex: Exception) {
            throw ex
        }
    }

//    @Transactional
//    fun addUser(addUserAddOrUpdateDto: UserAddOrUpdateDto): UserInfoDto {
//        ensureEmailIsAvailable(addUserAddOrUpdateDto.email)
//        val userModel: User = addUserAddOrUpdateDto.toUserModel(passwordEncoder)
//        val savedUser = userRepository.save(userModel)
//        return savedUser.toUserInfo()
//    }

    private fun ensureEmailIsAvailable(email: String) {
        if(userRepository.existsByEmailIgnoreCase(email)) {
            throw EmailAlreadyTakenException(email)
        }
    }

    fun ensureUserIsAvailable(userId: String): Boolean {
        return userRepository.existsById(userId)
    }
}