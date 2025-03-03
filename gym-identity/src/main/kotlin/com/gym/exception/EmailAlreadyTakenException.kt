package com.gym.exception

class EmailAlreadyTakenException(email: String): Exception(
    String.format("Email already taken: %s", email)
) {
}