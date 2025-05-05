package com.example.nowinjetpack.core.network.model

import com.squareup.moshi.Json

data class SeriesResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String
)