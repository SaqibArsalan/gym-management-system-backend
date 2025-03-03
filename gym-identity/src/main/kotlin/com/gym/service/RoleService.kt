package com.gym.service

import com.gym.controller.dto.RoleAddOrUpdateDto
import com.gym.controller.dto.RoleInfoDto
import com.gym.controller.dto.RoleToUserDto
import com.gym.exception.RoleNotPresentException
import com.gym.exception.UserNotPresentException
import com.gym.model.Role
import com.gym.repository.RoleRepository
import com.gym.repository.UserRoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleRepository: RoleRepository,
    private val userRoleRepository: UserRoleRepository,
    private val userService: UsersService
) {

    fun addRole(addOrUpdateDto: RoleAddOrUpdateDto): RoleInfoDto {
        val roleModel: Role = addOrUpdateDto.toRoleModel()
        val savedRole = roleRepository.save(roleModel)
        return savedRole.toRoleInfo()
    }

    fun verifyRole(roleId: String): Boolean {
        return roleRepository.existsById(roleId)
    }

    fun assignRoleToUser(roleToUserDto: RoleToUserDto) {
        if (!userService.ensureUserIsAvailable(roleToUserDto.userId)) {
            throw UserNotPresentException(roleToUserDto.userId)
        }
        if (!verifyRole(roleToUserDto.roleId)) {
            throw RoleNotPresentException(roleToUserDto.roleId)
        }

        val userRolesModel = roleToUserDto.toUser()
        userRoleRepository.save(userRolesModel)
    }
}