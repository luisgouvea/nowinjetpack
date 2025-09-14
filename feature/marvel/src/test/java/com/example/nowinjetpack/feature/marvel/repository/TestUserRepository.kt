package com.example.nowinjetpack.feature.marvel.repository

import com.example.nowinjetpack.core.data.repository.UserRepository
import com.example.nowinjetpack.core.model.data.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TestUserRepository : UserRepository {

    private val cachedTopics: MutableList<User> = mutableListOf()

    override fun getUser(): Flow<List<User>> = flowOf(
        cachedTopics
    )
}