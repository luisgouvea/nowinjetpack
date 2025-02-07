package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.data.mapper.ResultSeriesMapper
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SerieRepositoryImpl @Inject constructor(
    private val mapper: ResultSeriesMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSource
) : SerieRepository {

    override fun fetchSerie(id: Int): Flow<ResultSeries> = flow {
        emit(
            mapper.toDomain(nijNetworkDataSourceImpl.fetchSeries(id))
        )
    }
}