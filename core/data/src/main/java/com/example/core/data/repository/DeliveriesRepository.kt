package com.example.core.data.repository

import com.example.core.data.model.Delivery


interface DeliveriesRepository {
    suspend fun fetchDeliveries(
        page: Int
    ): List<Delivery>
}