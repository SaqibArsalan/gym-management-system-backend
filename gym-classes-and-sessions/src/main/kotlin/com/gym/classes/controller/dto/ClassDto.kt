package com.gym.com.gym.classes.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime
import java.time.LocalTime

@JsonIgnoreProperties(ignoreUnknown = true)
data class ClassDto(
    val className: String,
    val description: String,
    val trainerId: String,
    val capacity: Int,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
}