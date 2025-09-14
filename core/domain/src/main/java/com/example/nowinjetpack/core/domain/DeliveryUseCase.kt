package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.DeliveriesRepository
import com.example.nowinjetpack.core.model.data.Delivery
import javax.inject.Inject

//
//class DeliveryUseCase(
//    private val deliveriesRepository: DeliveriesRepository
//)  {
//    suspend fun fetchDeliveries(): List<Delivery> =
//        deliveriesRepository.fetchDeliveries(2)
//}


class DeliveryUseCase @Inject constructor(
    private val deliveriesRepository: DeliveriesRepository
)  {
    suspend fun fetchDeliveries(): List<Delivery> =
        deliveriesRepository.fetchDeliveries(2)
}