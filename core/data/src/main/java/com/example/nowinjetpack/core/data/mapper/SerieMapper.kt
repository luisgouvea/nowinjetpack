package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.Delivery
import com.example.nowinjetpack.core.model.data.Serie
import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.SeriesResponse

class SerieMapper : DomainMapper<SeriesResponse, Serie> {
    override fun toDomain(from: List<SeriesResponse>): List<Serie> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: SeriesResponse): Serie {
//        return Serie(
//            description = from.description
//        )
        return Serie(
            description = ""
        )
    }
}