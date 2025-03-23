package com.gym.membership.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class ActiveMembershipDto(
    val userId: String,
    val membershipPlanId: String,
    val memberName: String,
    val joinDate: LocalDate,
    val expiryDate: LocalDate,
    val membershipPlanName: String,
    val price: Double
) {
}