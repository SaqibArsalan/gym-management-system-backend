//package com.gym.util
//import io.jsonwebtoken.Jwts
//import org.springframework.stereotype.Component
//import java.util.*
//
//
//import org.springframework.security.core.Authentication
//import javax.crypto.SecretKey
//import javax.crypto.spec.SecretKeySpec
//
//@Component
//class JwtTokenProvider {
//
//    private val secretKey: SecretKey = SecretKeySpec("your-secret-key-here".toByteArray(), "HmacSHA256")
//    private val expirationTime: Long = 86400000 // 24 hours
//
//    // Generate JWT Token
//    fun generateToken(email: String): String {
//        return Jwts.builder()
//            .subject(email) // ✅ Modern way to set the subject
//            .issuedAt(Date())
//            .expiration(Date(System.currentTimeMillis() + 86400000)) // 1-day expiry
//            .compact() // ✅ Should now work
//    }
//
//    // Validate JWT Token
//    fun validateToken(token: String): Boolean {
//        return try {
////            getClaims(token)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    // Extract Username from Token
////    fun getUsername(token: String): String {
////        return getClaims(token).subject
////    }
//
//    // Get Authentication from Token
//    fun getAuthentication(token: String): Authentication {
////        val username = getUsername(token)
//        val userDetails = org.springframework.security.core.userdetails.User("username", "", emptyList())
//        return org.springframework.security.authentication.UsernamePasswordAuthenticationToken(userDetails, token, emptyList())
//    }
//
//    // Parse Token Claims
////    private fun getClaims(token: String): Claims {
////        return Jwts.parserBuilder()
////            .setSigningKey(secretKey)
////            .build()
////            .parseClaimsJws(token)
////            .body
////    }
//}
