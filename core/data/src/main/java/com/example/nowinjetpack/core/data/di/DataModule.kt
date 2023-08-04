package com.example.nowinjetpack.core.data.di

import com.example.nowinjetpack.core.data.mapper.DeliveriesMapper
import com.example.nowinjetpack.core.data.mapper.ResultSeriesMapper
import com.example.nowinjetpack.core.data.repository.DeliveriesRepository
import com.example.nowinjetpack.core.data.repository.DeliveriesRepositoryImpl
import com.example.nowinjetpack.core.data.repository.SerieRepository
import com.example.nowinjetpack.core.data.repository.SerieRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single { DeliveriesMapper() }
    single { ResultSeriesMapper() }

    single<DeliveriesRepository> { DeliveriesRepositoryImpl(get(), get()) }
    single<SerieRepository> { SerieRepositoryImpl(get(), get()) }
}