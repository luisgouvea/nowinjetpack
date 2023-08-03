package com.example.nowinjetpack.core.data.repository

import com.example.nowinjetpack.core.common.extensions.async
import com.example.nowinjetpack.core.data.mapper.SerieMapper
import com.example.nowinjetpack.core.model.data.Serie
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl

class SerieRepositoryImpl(
    private val mapper: SerieMapper,
    private val nijNetworkDataSourceImpl: NijNetworkDataSourceImpl
) : SerieRepository {

    override suspend fun fetchSerie(id: Int): Serie {
        return async { mapper.toDomain(nijNetworkDataSourceImpl.fetchSeries(id)) }
    }
}