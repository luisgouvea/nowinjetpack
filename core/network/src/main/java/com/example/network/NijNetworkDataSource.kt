package com.example.network

import com.example.network.model.DeliveryResponse


/**
 * Interface representing network calls to the NIJ backend
 */
interface NijNetworkDataSource {
    suspend fun fetchDeliveries(page: Int): List<DeliveryResponse>
}