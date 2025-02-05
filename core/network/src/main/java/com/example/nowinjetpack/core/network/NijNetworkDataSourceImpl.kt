package com.example.nowinjetpack.core.network

import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse
import com.example.nowinjetpack.core.network.retrofit.RetrofitNijNetwork


class NijNetworkDataSourceImpl(
    private val retrofitNijNetwork: RetrofitNijNetwork,
) : NijNetworkDataSource {
    override suspend fun fetchDeliveries(page: Int): List<DeliveryResponse> {
        return retrofitNijNetwork.fetchDeliveries(page)
    }

    override suspend fun fetchSeries(id: Int): ResultSeriesResponse {
        return retrofitNijNetwork.fetchSeries(id)
    }
}
