package com.gym.exception

class RoleNotPresentException(roleId: String): Exception(
    String.format("Cannot find role with roleId: %s", roleId)
) {
}