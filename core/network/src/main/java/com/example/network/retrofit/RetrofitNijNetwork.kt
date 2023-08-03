package com.example.network.retrofit

import com.example.network.NijNetworkDataSource
import com.example.network.model.DeliveryResponse
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
) : NijNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(NijBaseUrl)
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