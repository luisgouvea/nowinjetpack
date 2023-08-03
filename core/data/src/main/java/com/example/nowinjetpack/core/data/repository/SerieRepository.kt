package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.model.data.Serie

interface SerieRepository {
    suspend fun fetchSerie(
        id: Int
    ): Serie
}