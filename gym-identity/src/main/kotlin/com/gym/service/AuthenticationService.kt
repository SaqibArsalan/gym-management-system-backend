//package com.gym.service
//
//import com.gym.controller.dto.AuthenticationResponseDto
//import com.gym.controller.dto.CredentialDto
//import com.gym.repository.UserRepository
//import com.gym.util.JwtTokenProvider
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.BadCredentialsException
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
//import org.springframework.security.core.Authentication
//import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.stereotype.Service
//import org.springframework.transaction.annotation.Transactional
//
//@Service
//class AuthenticationService(
//    private val userRepository: UserRepository,
//    private val jwt: JwtTokenProvider,
//    private val authenticationManager: AuthenticationManager
//    ) {
//
//    @Transactional
//    fun authenticate(credentialDto: CredentialDto): AuthenticationResponseDto {
//        val user = userRepository.findByEmail(credentialDto.email).orElseThrow {
//            throw BadCredentialsException("User not found")
//        }
//
////        val roles = usersDetailsService.getRolesFor(user.roles)
//
//        try {
//            val authentication : Authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(user.email, credentialDto.password))
//            if (authentication.isAuthenticated) {
//                SecurityContextHolder.getContext().authentication = authentication
//                val token: String = jwt.generateToken(user.email)
//                return AuthenticationResponseDto(
//                    token,
//                    "",
//                    userInfoDto = user.toUserInfo(),
//                    "",
//                    "",
//                    listOf()
//                )
//            } else {
//                throw BadCredentialsException("Invalid token")
//            }
//        } catch (e : Exception) {
//            throw BadCredentialsException("Authentication error")
//        }
//    }
//}