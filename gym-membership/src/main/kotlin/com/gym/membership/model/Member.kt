package com.gym.membership.model

import com.gym.membership.controller.dto.MemberDto
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "members")
data class Member(
    @Column(name = "user_id")
    val userId: String = "",

    @Column(name = "membership_plan_id")
    val membershipPlanId: String = "",

    @Column(name = "join_date")
    val joinDate: LocalDate? = null,

    ) : BaseEntity() {

    companion object {
        fun createFrom(memberDto: MemberDto): Member {
            return Member(
                userId = memberDto.userId,
                membershipPlanId = memberDto.membershipPlanId,
                joinDate = memberDto.joinDate
            )
        }
    }
}



