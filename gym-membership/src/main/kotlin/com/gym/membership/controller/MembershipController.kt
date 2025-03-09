package com.gym.membership.controller

import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.service.MembershipSubscriptionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/memberships")
class MembershipController(val membershipSubscriptionService: MembershipSubscriptionService) {

    @PostMapping
    fun createMember(@RequestBody memberDto: MemberDto): ResponseEntity<MemberDto> {
        return ResponseEntity(membershipSubscriptionService.addMember(memberDto), HttpStatus.CREATED)
    }

}