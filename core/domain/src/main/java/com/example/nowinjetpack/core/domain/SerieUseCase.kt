package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.SerieRepository
import com.example.nowinjetpack.core.model.data.ResultSeries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SerieUseCase @Inject constructor(
    private val serieRepository: SerieRepository
)  {
    fun fetchSerie(): Flow<ResultSeries> =
        serieRepository.fetchSerie(1011334)
}