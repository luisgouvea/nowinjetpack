package com.example.nowinjetpack.core.network.model

import com.squareup.moshi.Json

data class SeriesResponse(
    @Json(name = "title") val title: String
)