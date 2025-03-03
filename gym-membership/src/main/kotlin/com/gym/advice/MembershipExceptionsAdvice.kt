package com.gym.advice


import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice(basePackages = ["com.gym"])
class MembershipExceptionsAdvice {
    private val logger: Logger = LogManager.getLogger(MembershipExceptionsAdvice::class.java)
    private val errorMessage = "An {} exception has occurred, errors : [{}]"
    private val _errorMessage = "An {} exception has occurred, errors : [{}], ex: {}"


//    @ExceptionHandler(UserNotPresentException::class)
//    fun handlerForUserNotException(ex: UserNotPresentException): ResponseEntity<Any> {
//        val errors: MutableList<String> = Collections.singletonList(ex.message)
//        logger.error(errorMessage, ex.javaClass.name, errors.joinToString(","), ex);
//        return ResponseEntity(
//            mapOf("errors" to ex.message),
//            HttpStatus.BAD_REQUEST
//        )
//    }
//
//    @ExceptionHandler(RoleNotPresentException::class)
//    fun handlerForFetchTourException(ex: RoleNotPresentException): ResponseEntity<Any> {
//        val errors: MutableList<String> = Collections.singletonList(ex.message)
//        logger.error(errorMessage, ex.javaClass.name, errors.joinToString(","), ex);
//        return ResponseEntity(
//            mapOf("errors" to ex.message),
//            HttpStatus.BAD_REQUEST
//        )
//    }

}