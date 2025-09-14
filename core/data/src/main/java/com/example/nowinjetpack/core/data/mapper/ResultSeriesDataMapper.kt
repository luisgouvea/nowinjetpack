package com.example.nowinjetpack.core.data.mapper

import com.example.nowinjetpack.core.common.mapper.DomainMapper
import com.example.nowinjetpack.core.model.data.ResultSeriesData
import com.example.nowinjetpack.core.network.model.ResultSeriesDataResponse
import javax.inject.Inject

class ResultSeriesDataMapper @Inject constructor() : DomainMapper<ResultSeriesDataResponse, ResultSeriesData> {
    override fun toDomain(from: List<ResultSeriesDataResponse>): List<ResultSeriesData> {
        return from.map { toDomain(it) }
    }

    override fun toDomain(from: ResultSeriesDataResponse): ResultSeriesData {
        return ResultSeriesData(
            results = SeriesMapper().toDomain(from.results)
        )
    }
}