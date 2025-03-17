package com.gym.membership.repository

import com.gym.membership.model.MembershipSubscription
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MembershipSubscriptionRepository: JpaRepository<MembershipSubscription, String> {

    @Query("SELECT m FROM MembershipSubscription m WHERE m.userId = :userId AND m.status = 'ACTIVE'")
    fun findActiveMembershipsByUserId(userId: String): List<MembershipSubscription>

    @Query("SELECT COUNT(m) FROM MembershipSubscription m WHERE m.status = 'ACTIVE'")
    fun countActiveMembers(): Long
}