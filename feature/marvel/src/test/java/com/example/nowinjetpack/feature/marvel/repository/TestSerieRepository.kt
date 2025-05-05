package com.example.nowinjetpack.feature.marvel.repository

import android.adservices.topics.Topic
import com.example.nowinjetpack.core.data.repository.SerieRepository
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.model.data.Series
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class TestSerieRepository : SerieRepository {

    private val cachedTopics: MutableList<Series> = mutableListOf()

    override fun fetchSerie(id: Int): Flow<ResultSeries> = flowOf(
        ResultSeries(
            data = cachedTopics.filter { algo ->
                algo.id == id
            }
        ),
    )
}