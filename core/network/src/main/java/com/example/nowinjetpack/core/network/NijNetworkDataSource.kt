package com.example.nowinjetpack.core.network

import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.SeriesResponse


/**
 * Interface representing network calls to the NIJ backend
 */
interface NijNetworkDataSource {
    suspend fun fetchDeliveries(page: Int): List<DeliveryResponse>

    suspend fun fetchSeries(page: Int): SeriesResponse
}