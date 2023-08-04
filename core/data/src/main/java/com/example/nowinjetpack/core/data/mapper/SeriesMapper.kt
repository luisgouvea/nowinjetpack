package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.Series
import com.example.nowinjetpack.core.network.model.SeriesResponse

class SeriesMapper :
    DomainMapper<SeriesResponse, Series> {
    override fun toDomain(from: List<SeriesResponse>): List<Series> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: SeriesResponse): Series {
        return Series(
            title = from.title
        )
    }
}