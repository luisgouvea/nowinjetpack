package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse
import javax.inject.Inject

class ResultSeriesMapper @Inject constructor(): DomainMapper<ResultSeriesResponse, ResultSeries> {
    override fun toDomain(from: List<ResultSeriesResponse>): List<ResultSeries> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: ResultSeriesResponse): ResultSeries {
        return ResultSeries(
            data = SeriesMapper().toDomain(from.data)
        )
    }
}
