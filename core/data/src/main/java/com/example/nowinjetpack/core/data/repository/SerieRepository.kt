package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.model.data.ResultSeries

interface SerieRepository {
    suspend fun fetchSerie(
        id: Int
    ): ResultSeries
}