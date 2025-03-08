package com.gym.membership.service

import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.controller.dto.MembershipPlanDto
import com.gym.membership.exception.FailedToCreateMemberException
import com.gym.membership.exception.FailedToCreateMembershipPlanException
import com.gym.membership.model.Member
import com.gym.membership.model.MembershipPlans
import com.gym.membership.repository.MemberRepository
import com.gym.membership.repository.MembershipPlanRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository
    ) {

    @Transactional
    fun addMember(memberDto: MemberDto): MemberDto {

        try {
            val memberModel = Member.createFrom(memberDto)
            memberRepository.save(memberModel)
            return memberDto

        } catch (e : Exception) {
            throw FailedToCreateMemberException()
        }
    }
}