package com.gym.repository

import com.gym.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, String> {

    override fun findAll(): List<User>

    override fun findById(id: String): Optional<User>
    fun findByEmail(email: String): Optional<User>
    fun existsByEmailIgnoreCase(email: String): Boolean

}