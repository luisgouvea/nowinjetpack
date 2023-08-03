package com.example.network

import com.example.network.model.DeliveryResponse
import com.example.network.retrofit.RetrofitNijNetwork


class NijNetworkDataSourceImpl(
    private val retrofitNijNetwork: RetrofitNijNetwork,
) : NijNetworkDataSource {
    override suspend fun fetchDeliveries(page: Int): List<DeliveryResponse> {
        return retrofitNijNetwork.fetchDeliveries(page)
    }
}
