package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.network.model.DeliveryResponse
import javax.inject.Inject

class DeliveriesMapper @Inject constructor(): DomainMapper<DeliveryResponse, Delivery> {
    override fun toDomain(from: List<DeliveryResponse>): List<Delivery> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: DeliveryResponse): Delivery {
        return Delivery(
            hasTracking = from.hasTracking,
            date = from.date
        )
    }
}