package com.gym.membership.controller

import com.gym.membership.service.MembershipPlanService
import com.gym.membership.controller.dto.MembershipPlanDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/memberships/plans")
class MembershipPlanController(val membershipPlanService: MembershipPlanService) {

    @PostMapping
    fun createPlan(@RequestBody planDto: MembershipPlanDto): ResponseEntity<MembershipPlanDto> {
        return ResponseEntity(membershipPlanService.createPlan(planDto), HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllPlans(): ResponseEntity<List<MembershipPlanDto>> {
        return ResponseEntity(membershipPlanService.getAllPlans(), HttpStatus.OK)
    }

    @GetMapping("{planId}")
    fun getPlan(@PathVariable planId: String): ResponseEntity<MembershipPlanDto> {
        return ResponseEntity(membershipPlanService.getPlan(planId), HttpStatus.OK)
    }

}