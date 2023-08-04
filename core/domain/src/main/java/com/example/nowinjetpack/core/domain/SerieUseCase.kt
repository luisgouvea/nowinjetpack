package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.model.ResultSeries
import com.example.nowinjetpack.core.data.repository.SerieRepository

class SerieUseCase(
    private val serieRepository: SerieRepository
)  {
    suspend fun fetchSerie(): ResultSeries =
        serieRepository.fetchSerie(1011334)
}