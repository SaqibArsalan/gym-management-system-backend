package com.gym.service

import com.gym.controller.dto.MembershipPlanDto
import com.gym.exception.FailedToCreateMembershipPlanException
import com.gym.model.MembershipPlans
import com.gym.repository.MembershipPlanRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MembershipPlanService(
    private val membershipPlanRepository: MembershipPlanRepository
    ) {

    @Transactional
    fun createPlan(membershipPlanDto: MembershipPlanDto): MembershipPlanDto {

        try {
            val membershipModel = MembershipPlans.createFrom(membershipPlanDto)
            membershipPlanRepository.save(membershipModel)
            return membershipPlanDto

        } catch (e : Exception) {
            throw FailedToCreateMembershipPlanException()
        }
    }
}