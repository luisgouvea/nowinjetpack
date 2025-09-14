package com.example.nowinjetpack.core.network.retrofit

import com.example.nowinjetpack.core.network.model.DeliveryResponse
import com.example.nowinjetpack.core.network.model.ResultSeriesResponse
import com.example.nowinjetpack.core.network.model.UserResponse
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Retrofit API declaration for NIJ Network API
 */
interface RetrofitNijNetworkApi {


    @GET("/v1/public/characters/{id}/comics")
    suspend fun getComics(
        @Path("id") id: Int
    ): ResultSeriesResponse

    @GET("/meuspedidos/v2/listagem")
    suspend fun getDeliveries(
        @Query("pagina") page: Int
    ): List<DeliveryResponse>

    @GET("/users")
    suspend fun getUsers(): List<UserResponse>
}

const val NijBaseUrl = "url"

/**
 * Wrapper for data provided from the [NijBaseUrl]
 */
@Serializable
data class NetworkResponse<T>(
    val data: T,
)