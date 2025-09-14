package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.User
import com.example.nowinjetpack.core.network.model.UserResponse
import javax.inject.Inject

class UserMapper @Inject constructor(): DomainMapper<UserResponse, User> {
    override fun toDomain(from: List<UserResponse>): List<User> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: UserResponse): User {
        return User(
            id = from.id,
            name = from.name
        )
    }
}