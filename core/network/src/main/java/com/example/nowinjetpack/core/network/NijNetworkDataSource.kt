package com.example.nowinjetpack.core.network

import com.example.nowinjetpack.core.network.model.DeliveryResponse


/**
 * Interface representing network calls to the NIJ backend
 */
interface NijNetworkDataSource {
    suspend fun fetchDeliveries(page: Int): List<DeliveryResponse>
}