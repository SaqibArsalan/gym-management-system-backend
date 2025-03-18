package com.gym.membership.repository

import com.gym.membership.model.MembershipSubscription
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MembershipSubscriptionRepository: JpaRepository<MembershipSubscription, String> {

    @Query("SELECT m FROM MembershipSubscription m WHERE m.userId = :userId AND m.status = 'ACTIVE'")
    fun findActiveMembershipsByUserId(userId: String): List<MembershipSubscription>

    @Query("SELECT COUNT(DISTINCT m.userId) FROM MembershipSubscription m WHERE m.status = 'ACTIVE'")
    fun countActiveMembers(): Long

    @Query("SELECT COUNT(m) FROM MembershipSubscription m WHERE m.status = 'ACTIVE'")
    fun countActiveSubscriptions(): Long

    @Query("""
        SELECT COUNT(DISTINCT m.userId) FROM MembershipSubscription m 
    WHERE FUNCTION('DATE_TRUNC', 'MONTH', m.joinDate) = FUNCTION('DATE_TRUNC', 'MONTH', CURRENT_DATE) 
        
    """)
    fun countNewSignups(): Long
}