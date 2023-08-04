package com.example.nowinjetpack.core.network

import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse


/**
 * Interface representing network calls to the NIJ backend
 */
interface NijNetworkDataSource {
    suspend fun fetchDeliveries(page: Int): List<DeliveryResponse>

    suspend fun fetchSeries(page: Int): ResultSeriesResponse
}