package com.gym.repository

import com.gym.model.MembershipPlans
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MembershipPlanRepository: JpaRepository<MembershipPlans, String> {
}