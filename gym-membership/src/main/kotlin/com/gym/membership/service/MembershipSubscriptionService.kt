package com.gym.membership.service

import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.exception.FailedToCreateMemberException
import com.gym.membership.exception.FailedToFetchMembershipPlanForIdException
import com.gym.membership.model.MembershipSubscription
import com.gym.membership.repository.MembershipSubscriptionRepository
import com.gym.membership.repository.MembershipPlanRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MembershipSubscriptionService(
    private val membershipSubscriptionRepository: MembershipSubscriptionRepository,
    private val membershipPlanRepository: MembershipPlanRepository
    ) {

    @Transactional
    fun addMember(memberDto: MemberDto): MemberDto {

        try {
            val membershipPlan = membershipPlanRepository.findById(memberDto.membershipPlanId).orElseThrow {
                FailedToFetchMembershipPlanForIdException(memberDto.membershipPlanId)
            }
            val membershipSubscriptionModel = MembershipSubscription.createFrom(memberDto, membershipPlan)
            membershipSubscriptionRepository.save(membershipSubscriptionModel)
            return memberDto

        } catch (ex: FailedToFetchMembershipPlanForIdException) {
            throw ex
        } catch (e: Exception) {
            throw FailedToCreateMemberException()
        }
    }
}