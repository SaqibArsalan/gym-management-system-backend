package com.gym.repository

import com.gym.model.UserRoles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRoleRepository : JpaRepository<UserRoles, String> {

}