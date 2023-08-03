package com.example.core.data.repository

import com.example.nowinjetpack.core.common.extensions.async
import com.example.core.data.mapper.DeliveriesMapper
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl

/**
 * Implementation of the [DeliveriesRepository] that retrieves the news resources from API.
 */

class DeliveriesRepositoryImpl(
    private val mapper: DeliveriesMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSourceImpl
) : DeliveriesRepository {

    override suspend fun fetchDeliveries(page: Int): List<Delivery> {
        return async { mapper.toDomain(nijNetworkDataSourceImpl.fetchDeliveries(page)) }
    }
}