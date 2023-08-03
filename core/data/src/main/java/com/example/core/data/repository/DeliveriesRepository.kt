package com.example.core.data.repository

import com.example.core.model.data.Delivery


interface DeliveriesRepository {
    suspend fun fetchDeliveries(
        page: Int
    ): List<Delivery>
}