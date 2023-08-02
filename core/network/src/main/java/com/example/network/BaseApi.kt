package com.example.network

import com.example.network.model.DeliveryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApi {
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