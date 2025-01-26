package com.example.nowinjetpack.core.data.di

import com.example.nowinjetpack.core.data.repository.DeliveriesRepository
import com.example.nowinjetpack.core.data.repository.DeliveriesRepositoryImpl
import com.example.nowinjetpack.core.data.repository.SerieRepository
import com.example.nowinjetpack.core.data.repository.SerieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleHilt {
    @Binds
    abstract fun bindSerieRepositoryImplNova(
        serieRepositoryImpl: SerieRepositoryImpl
    ): SerieRepository

    @Binds
    abstract fun bindQualquer(
        deliveriesRepositoryImpl: DeliveriesRepositoryImpl
    ): DeliveriesRepository
}