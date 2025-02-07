package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.model.data.ResultSeries
import kotlinx.coroutines.flow.Flow

interface SerieRepositoryNew {
    fun fetchSerie(
        id: Int
    ): Flow<ResultSeries>
}