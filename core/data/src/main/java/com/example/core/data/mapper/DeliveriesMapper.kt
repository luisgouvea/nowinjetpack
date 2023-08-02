package com.example.core.data.mapper

import com.example.core.common.mapper.DomainMapper
import com.example.core.data.model.Delivery
import com.example.network.model.DeliveryResponse

class DeliveriesMapper : DomainMapper<DeliveryResponse, Delivery> {
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