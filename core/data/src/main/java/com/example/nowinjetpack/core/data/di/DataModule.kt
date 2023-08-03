package com.example.nowinjetpack.core.data.di

import com.example.nowinjetpack.core.data.mapper.DeliveriesMapper
import com.example.nowinjetpack.core.data.repository.DeliveriesRepository
import com.example.nowinjetpack.core.data.repository.DeliveriesRepositoryImpl
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl
import org.koin.dsl.module

val dataModule = module {
    single { DeliveriesMapper() }

    single<DeliveriesRepository> { DeliveriesRepositoryImpl(get(), get()) }
    //single<DeliveriesRepository> { DeliveriesRepositoryImpl(get()) }
}