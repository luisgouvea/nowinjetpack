package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.common.extensions.async
import com.example.nowinjetpack.core.data.mapper.ResultSeriesMapper
import com.example.nowinjetpack.core.data.model.ResultSeries
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl

class SerieRepositoryImpl(
    private val mapper: ResultSeriesMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSourceImpl
) : SerieRepository {

    override suspend fun fetchSerie(id: Int): ResultSeries {
        return async { mapper.toDomain(nijNetworkDataSourceImpl.fetchSeries(id)) }
    }
}