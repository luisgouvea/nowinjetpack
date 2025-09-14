package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.common.extensions.async
import com.example.nowinjetpack.core.data.mapper.DeliveriesMapper
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import javax.inject.Inject

/**
 * Implementation of the [DeliveriesRepository] that retrieves the news resources from API.
 */

class DeliveriesRepositoryImpl @Inject constructor(
    private val mapper: DeliveriesMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSource
) : DeliveriesRepository {

    override suspend fun fetchDeliveries(page: Int): List<Delivery> {
        return async { mapper.toDomain(nijNetworkDataSourceImpl.fetchDeliveries(page)) }
    }
}