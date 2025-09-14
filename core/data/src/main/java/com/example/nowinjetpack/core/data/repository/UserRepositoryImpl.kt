package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.data.mapper.ResultSeriesMapper
import com.example.nowinjetpack.core.data.mapper.UserMapper
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.model.data.User
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.model.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val mapper: UserMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSource
) : UserRepository {

    override fun getUser(): Flow<List<User>> = flow {
        emit(
            mapper.toDomain(nijNetworkDataSourceImpl.fetchUser())
        )
    }
}