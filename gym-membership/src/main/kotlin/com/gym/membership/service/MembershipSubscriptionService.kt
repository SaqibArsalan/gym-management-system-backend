package com.gym.membership.service

import com.gym.membership.controller.dto.ActiveMembershipDto
import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.exception.FailedToCreateMemberException
import com.gym.membership.exception.FailedToFetchActiveMembershipsExceptionForUser
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
    fun addMembershipSubscription(memberDto: MemberDto): MemberDto {

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

    fun getActiveMemberships(userId: String): List<ActiveMembershipDto> {
        try {
            val activeMemberships = membershipSubscriptionRepository.findActiveMembershipsByUserId(userId)

            return activeMemberships.map {
                    membership -> ActiveMembershipDto(
                membership.userId,
                membership.membershipPlan.id!!,
                membership.joinDate,
                membership.expiryDate!!,
                membership.membershipPlan.name,
                membership.membershipPlan.price)
            }
        } catch (ex: Exception) {
            throw FailedToFetchActiveMembershipsExceptionForUser(userId)
        }
    }
}