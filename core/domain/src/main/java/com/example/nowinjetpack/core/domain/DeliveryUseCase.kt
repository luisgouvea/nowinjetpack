package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.DeliveriesRepository
import com.example.nowinjetpack.core.model.data.Delivery

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