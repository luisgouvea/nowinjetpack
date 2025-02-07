package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.SerieRepositoryNew
import com.example.nowinjetpack.core.model.data.ResultSeries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SerieUseCaseNew @Inject constructor(
    private val serieRepositoryNew: SerieRepositoryNew
)  {
    fun fetchSerie(): Flow<ResultSeries> =
        serieRepositoryNew.fetchSerie(1011334)
}