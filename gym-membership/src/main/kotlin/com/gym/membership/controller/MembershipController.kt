package com.gym.membership.controller

import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.service.MembershipPlanService
import com.gym.membership.controller.dto.MembershipPlanDto
import com.gym.membership.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/memberships")
class MembershipController(val memberService: MemberService) {

    @PostMapping
    fun createMember(@RequestBody memberDto: MemberDto): ResponseEntity<MemberDto> {
        return ResponseEntity(memberService.addMember(memberDto), HttpStatus.CREATED)
    }

}