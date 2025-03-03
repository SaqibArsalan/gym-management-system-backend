//package com.gym.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.authentication.AuthenticationManager
//import org.springframework.security.authentication.AuthenticationProvider
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.http.SessionCreationPolicy
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.SecurityFilterChain
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
//
//@Configuration
//class AuthenticationSecurityConfiguration(
////    private val customUserDetailsService: UserDetailsService, // Avoid circular dependency
////    private val jwtAuthenticationFilter: JwtAuthenticationFilter
//) {
//
//    @Bean
//    fun passwordEncoder(): PasswordEncoder {
//        return BCryptPasswordEncoder()
//    }
//
////    @Bean
////    fun authenticationProvider(): AuthenticationProvider {
////        val authProvider = DaoAuthenticationProvider()
////        authProvider.setUserDetailsService(customUserDetailsService)
////        authProvider.setPasswordEncoder(passwordEncoder()) // Ensures passwords are checked correctly
////        return authProvider
////    }
//
////    @Bean
////    fun authenticationManager(authenticationProvider: AuthenticationProvider): AuthenticationManager {
////        return org.springframework.security.authentication.ProviderManager(authenticationProvider)
////    }
//
//    @Bean
//    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
//        http
//            .csrf { it.disable() }
//            .authorizeHttpRequests {
//                it.requestMatchers("/v1/auth/login").permitAll()
//                it.requestMatchers("/v1/*").permitAll()
//                it.anyRequest().authenticated()
//            }
//            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
////            .authenticationProvider(authenticationProvider())
////            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java) // ✅ Add JWT Filter
//
//        return http.build()
//    }
//}
