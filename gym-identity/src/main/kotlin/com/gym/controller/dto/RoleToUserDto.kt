package com.gym.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.gym.model.UserRoles

@JsonIgnoreProperties(ignoreUnknown = true)
data class RoleToUserDto(
    val userId: String = "",
    val roleId: String = ""

) {

    fun toUser(): UserRoles {
        return UserRoles(userId, roleId)
    }

}