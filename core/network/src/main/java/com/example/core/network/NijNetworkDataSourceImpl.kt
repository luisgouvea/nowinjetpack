package com.example.core.network

import com.example.core.network.model.DeliveryResponse
import com.example.core.network.retrofit.RetrofitNijNetwork


class NijNetworkDataSourceImpl(
    private val retrofitNijNetwork: RetrofitNijNetwork,
) : NijNetworkDataSource {
    override suspend fun fetchDeliveries(page: Int): List<DeliveryResponse> {
        return retrofitNijNetwork.fetchDeliveries(page)
    }
}
