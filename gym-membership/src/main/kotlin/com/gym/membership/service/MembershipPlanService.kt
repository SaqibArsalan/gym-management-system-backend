package com.gym.membership.service

import com.gym.membership.controller.dto.MembershipPlanDto
import com.gym.membership.exception.FailedToCreateMembershipPlanException
import com.gym.membership.model.MembershipPlans
import com.gym.membership.repository.MembershipPlanRepository
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