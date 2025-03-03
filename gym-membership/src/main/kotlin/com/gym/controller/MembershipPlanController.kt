package com.gym.controller

import com.gym.service.MembershipPlanService
import com.gym.controller.dto.MembershipPlanDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/memberships/plans")
class MembershipPlanController(val membershipPlanService: MembershipPlanService) {

    @PostMapping
    fun createPlan(@RequestBody planDto: MembershipPlanDto): ResponseEntity<MembershipPlanDto> {
        return ResponseEntity(membershipPlanService.createPlan(planDto), HttpStatus.CREATED)
    }

}