package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.model.data.User
import com.example.nowinjetpack.core.network.model.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(
    ): Flow<List<User>>
}