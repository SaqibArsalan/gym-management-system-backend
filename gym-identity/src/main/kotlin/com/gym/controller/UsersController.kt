package com.gym.controller

import com.gym.controller.dto.UserAddOrUpdateDto
import com.gym.controller.dto.UserInfoDto
import com.gym.model.User
import com.gym.service.UsersService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/identity/users")
class UsersController(val usersService: UsersService) {

    @GetMapping
    fun getUsers(): List<User> {
        return usersService.getUsers()
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable userId: String): UserInfoDto {
        return usersService.getUser(userId)
    }

//    @PostMapping
//    fun addUser(@RequestBody addUserAddOrUpdateDto: UserAddOrUpdateDto): ResponseEntity<*> {
//        return ResponseEntity(usersService.addUser(addUserAddOrUpdateDto), HttpStatus.OK)
//    }

}