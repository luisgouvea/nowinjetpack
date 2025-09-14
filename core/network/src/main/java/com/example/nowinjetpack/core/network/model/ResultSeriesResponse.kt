package com.example.nowinjetpack.core.network.model


import com.squareup.moshi.Json

data class ResultSeriesResponse(
    @Json(name = "data") val data: List<SeriesResponse>
)



