package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.data.model.ResultSeries
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse

class ResultSeriesMapper : DomainMapper<ResultSeriesResponse, ResultSeries> {
    override fun toDomain(from: List<ResultSeriesResponse>): List<ResultSeries> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: ResultSeriesResponse): ResultSeries {
        return ResultSeries(
            data = from.data
        )
    }
}
