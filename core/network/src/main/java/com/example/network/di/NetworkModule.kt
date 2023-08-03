package com.example.network.di

import com.example.network.NijNetworkDataSource
import com.example.network.NijNetworkDataSourceImpl
import com.example.network.retrofit.RetrofitNijNetwork
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitNijNetwork(get()) }
    single<NijNetworkDataSource> { NijNetworkDataSourceImpl(get()) }
}