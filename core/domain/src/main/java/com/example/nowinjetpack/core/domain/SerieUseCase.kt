package com.example.nowinjetpack.core.domain

import com.example.nowinjetpack.core.data.repository.SerieRepository
import com.example.nowinjetpack.core.model.data.ResultSeries

class SerieUseCase(
    private val serieRepository: SerieRepository
)  {
    suspend fun fetchSerie(): ResultSeries =
        serieRepository.fetchSerie(1011334)
}