package com.example.nowinjetpack.core.network.model

import com.squareup.moshi.Json

data class DeliveryResponse(
    @Json(name = "data") val date: String?,
    @Json(name = "possuiRastreamento") val hasTracking: Boolean?
)