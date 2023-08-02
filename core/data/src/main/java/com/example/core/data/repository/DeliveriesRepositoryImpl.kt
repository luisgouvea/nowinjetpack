package com.example.core.data.repository

import com.example.core.common.extensions.async
import com.example.core.data.mapper.DeliveriesMapper
import com.example.core.data.model.Delivery
import com.example.network.BaseApi

class DeliveriesRepositoryImpl(
    private val api: BaseApi,
    private val mapper: DeliveriesMapper
) : DeliveriesRepository {

    override suspend fun fetchDeliveries(page: Int): List<Delivery> {
        return async { mapper.toDomain(api.getDeliveries(page)) }
    }
}