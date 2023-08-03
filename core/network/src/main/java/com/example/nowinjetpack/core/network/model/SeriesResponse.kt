package com.example.nowinjetpack.core.network.model


import com.squareup.moshi.Json
//
//data class SeriesResponse(
//    @Json(name = "description") val description: String?,
//)


data class SeriesResponse(
    val data: SerieDataResponse
)

data class SerieDataResponse(
    val results: List<ResultSerieResponse>
)

data class ResultSerieResponse(
    val description: String? = "",
    val id: String
)