package com.gym.classes.controller

import com.gym.classes.service.ClassManagementService
import com.gym.com.gym.classes.controller.dto.ClassDto
import com.gym.com.gym.classes.controller.dto.ClassResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/classes")
class ClassManagementController(val classManagementService: ClassManagementService) {

    @PostMapping
    fun createClass(@RequestBody classDto: ClassDto): ResponseEntity<ClassResponseDto> {
        return ResponseEntity(classManagementService.createClass(classDto), HttpStatus.CREATED)
    }

    @GetMapping
    fun getClasses(): ResponseEntity<List<ClassResponseDto>> {
        return ResponseEntity(classManagementService.getAllClasses(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getClassDetails(@PathVariable id: String): ResponseEntity<ClassDto> {
        return ResponseEntity(classManagementService.getClassDetails(id), HttpStatus.OK)
    }

}