package com.gym.membership.controller

import com.gym.membership.controller.dto.ActiveMembershipDto
import com.gym.membership.controller.dto.MemberDto
import com.gym.membership.service.MembershipSubscriptionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/memberships")
class MembershipSubscriptionController(val membershipSubscriptionService: MembershipSubscriptionService) {

    @PostMapping
    fun createMembershipSubscription(@RequestBody memberDto: MemberDto): ResponseEntity<MemberDto> {
        return ResponseEntity(membershipSubscriptionService.addMembershipSubscription(memberDto), HttpStatus.CREATED)
    }

    @GetMapping("{userId}")
    fun getActiveMemberships(@PathVariable userId: String): ResponseEntity<List<ActiveMembershipDto>> {
        return ResponseEntity(membershipSubscriptionService.getActiveMemberships(userId), HttpStatus.OK)
    }

    @GetMapping("/active-subscriptions")
    fun getTotalActiveSubscriptions(): ResponseEntity<Long> {
        return ResponseEntity(membershipSubscriptionService.getTotalActiveSubscriptions(), HttpStatus.OK)
    }

    @GetMapping("/members")
    fun getTotalActiveMembers(): ResponseEntity<Long> {
        return ResponseEntity(membershipSubscriptionService.getTotalActiveMembers(), HttpStatus.OK)
    }

}