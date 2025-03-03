package com.gym.membership.model

import com.gym.membership.model.BaseEntity
import jakarta.persistence.*
import java.sql.Timestamp


@Entity
@Table(name = "members")
data class Member(
    @Column(name = "user_id")
    val userId: String = "",

    @Column(name = "membership_plan_id")
    val membershipPlanId: String = "",

    @Column(name = "join_date")
    val joinDate: Timestamp = Timestamp.valueOf("1970-01-01 05:01:01")

) : BaseEntity() {
}



