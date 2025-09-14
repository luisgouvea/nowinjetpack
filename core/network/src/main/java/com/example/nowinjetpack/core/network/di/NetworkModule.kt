package com.example.nowinjetpack.core.network.di

import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.retrofit.RetrofitNijNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindsNetwork(
        addressRemoteRepositoryImpl: RetrofitNijNetwork
    ): NijNetworkDataSource

}