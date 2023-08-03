package com.example.core.network.retrofit

import com.example.core.network.NijNetworkDataSource
import com.example.core.network.model.DeliveryResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * [Retrofit] backed [NijNetworkDataSource]
 */
class RetrofitNijNetwork(
    okHttpClient: OkHttpClient,
    nijBaseUrl: String
) : NijNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(nijBaseUrl)
        .client(okHttpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                getMoshi()
            )
        )
        .build()
        .create(RetrofitNijNetworkApi::class.java)

    private fun getMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    override suspend fun fetchDeliveries(page: Int): List<DeliveryResponse> =
        networkApi.getDeliveries(page)

}