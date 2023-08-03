package com.example.core.network.retrofit

import com.example.core.network.model.DeliveryResponse
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Retrofit API declaration for NIA Network API
 */
internal interface RetrofitNijNetworkApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("nameStartsWith") term: String?
    ): Unit

    @GET("/meuspedidos/v2/listagem")
    suspend fun getDeliveries(
        @Query("pagina") page: Int
    ): List<DeliveryResponse>
}

const val NijBaseUrl = "url"

/**
 * Wrapper for data provided from the [NijBaseUrl]
 */
@Serializable
data class NetworkResponse<T>(
    val data: T,
)