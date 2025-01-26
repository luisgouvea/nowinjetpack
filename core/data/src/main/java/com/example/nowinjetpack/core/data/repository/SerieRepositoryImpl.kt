package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.common.extensions.async
import com.example.nowinjetpack.core.data.mapper.ResultSeriesMapper
import com.example.nowinjetpack.core.model.data.ResultSeries
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import javax.inject.Inject

class SerieRepositoryImpl @Inject constructor(
    private val mapper: ResultSeriesMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSource
) : SerieRepository {

    override suspend fun fetchSerie(id: Int): ResultSeries {
        return async { mapper.toDomain(nijNetworkDataSourceImpl.fetchSeries(id)) }
    }
}