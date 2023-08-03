package com.example.core.domain

import com.example.core.data.repository.DeliveriesRepository
import com.example.core.model.data.Delivery

//
//class DeliveryUseCase(
//    private val deliveriesRepository: DeliveriesRepository
//)  {
//    suspend fun fetchDeliveries(): List<Delivery> =
//        deliveriesRepository.fetchDeliveries(2)
//}


class DeliveryUseCase(
    private val deliveriesRepository: DeliveriesRepository
)  {
    suspend fun fetchDeliveries(): List<Delivery> =
        deliveriesRepository.fetchDeliveries(2)
}