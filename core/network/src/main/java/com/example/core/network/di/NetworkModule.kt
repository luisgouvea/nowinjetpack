package com.example.core.network.di

import com.example.network.BuildConfig
import com.example.core.network.NijNetworkDataSource
import com.example.core.network.NijNetworkDataSourceImpl
import com.example.core.network.retrofit.RetrofitNijNetwork
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { createOkHttpClient() }
    single { RetrofitNijNetwork(get(), BuildConfig.BASE_URL) }
    single { NijNetworkDataSourceImpl(get()) }
    single<NijNetworkDataSource> { NijNetworkDataSourceImpl(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()

}