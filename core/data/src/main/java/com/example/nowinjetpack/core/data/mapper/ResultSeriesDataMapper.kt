package com.example.nowinjetpack.core.data.mapper
//
//import com.example.nowinjetpack.core.common.mapper.DomainMapper
//import com.example.nowinjetpack.core.data.model.ResultSeriesData
//import com.example.nowinjetpack.core.model.data.SerieTest
//import com.example.nowinjetpack.core.network.model.ResultSeriesDataResponse
//import com.example.nowinjetpack.core.network.model.ResultSeriesResponse
//
//class ResultSeriesDataMapper : DomainMapper<ResultSeriesDataResponse, ResultSeriesData> {
//    override fun toDomain(from: List<ResultSeriesDataResponse>): List<ResultSeriesData> {
//        return from.map { toDomain(it) }
//    }
//
//    override fun toDomain(from: ResultSeriesDataResponse): ResultSeriesData {
//        return ResultSeriesData(
//            results = from.results
//        )
//    }
//}