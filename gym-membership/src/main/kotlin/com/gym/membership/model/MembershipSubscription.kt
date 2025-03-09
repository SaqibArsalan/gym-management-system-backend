package com.gym.membership.model

import com.gym.membership.controller.dto.MemberDto
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "membership_subscriptions")
data class MembershipSubscription(
    @Column(name = "user_id")
    val userId: String = "",

    @Column(name = "join_date")
    val joinDate: LocalDate = LocalDate.now(),

    @Column(name = "expiry_date")
    val expiryDate: LocalDate? = null,

    @ManyToOne
    @JoinColumn(name = "membership_plan_id", nullable = false) // Foreign key to membership_plans table
    val membershipPlan: MembershipPlans = MembershipPlans()

    ) : BaseEntity() {

    companion object {
        fun createFrom(memberDto: MemberDto, membershipPlan: MembershipPlans): MembershipSubscription {
            return MembershipSubscription(
                userId = memberDto.userId,
                joinDate = memberDto.joinDate,
                expiryDate = calculateExpiryDate(memberDto.joinDate, memberDto.durationInMonths),
                membershipPlan = membershipPlan,
            )
        }

        fun calculateExpiryDate(joinDate: LocalDate, durationInMonths: Int): LocalDate {
            return joinDate.plusMonths(durationInMonths.toLong())
        }
    }
}



