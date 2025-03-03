package com.gym.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MembershipPlanDto(
    val name: String,
    val durationInMonths: Int,
    val price: Double,
    val description: String
) {
}