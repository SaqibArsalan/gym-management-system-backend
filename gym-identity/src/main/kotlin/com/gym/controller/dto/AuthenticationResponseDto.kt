package com.gym.controller.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthenticationResponseDto(
    val token: String,
    val legacyToken: String,
    val userInfoDto: UserInfoDto,
    val expiresAt: String,
    val refreshToken: String,
    val roles: List<String>

) {}