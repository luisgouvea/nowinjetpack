package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.UserRepository
import com.example.nowinjetpack.core.model.data.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository
)  {
    fun getUser(): Flow<List<User>> =
        userRepository.getUser()
}