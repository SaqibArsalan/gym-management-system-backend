package com.gym.exception

class UserNotPresentException(userId: String): Exception(
    String.format("Cannot find user with userId: %s", userId)
) {
}