package com.example.core.data.di

import com.example.core.data.mapper.DeliveriesMapper
import com.example.core.data.repository.DeliveriesRepository
import com.example.core.data.repository.DeliveriesRepositoryImpl
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl
import org.koin.dsl.module

val dataModule = module {
    single { DeliveriesMapper() }

    single<DeliveriesRepository> { DeliveriesRepositoryImpl(get(), get()) }
    //single<DeliveriesRepository> { DeliveriesRepositoryImpl(get()) }
}