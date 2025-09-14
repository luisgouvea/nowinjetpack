package com.example.nowinjetpack.core.network.retrofit

import com.example.network.BuildConfig
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse
import com.example.nowinjetpack.core.network.model.UserResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * [Retrofit] backed [NijNetworkDataSource]
 */
@Singleton
class RetrofitNijNetwork @Inject constructor(
    okHttpClient: OkHttpClient
) : NijNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
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

    override suspend fun fetchSeries(id: Int): ResultSeriesResponse =
        networkApi.getComics(id)

    override suspend fun fetchUser(): List<UserResponse> =
        networkApi.getUsers()

}