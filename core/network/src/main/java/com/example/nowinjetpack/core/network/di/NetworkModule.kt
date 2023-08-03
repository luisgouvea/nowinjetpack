package com.example.nowinjetpack.core.network.di

import com.example.network.BuildConfig
import com.example.nowinjetpack.core.network.NijNetworkDataSource
import com.example.nowinjetpack.core.network.NijNetworkDataSourceImpl
import com.example.nowinjetpack.core.network.retrofit.RetrofitNijNetwork
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import okhttp3.Response
import okhttp3.Interceptor
import java.security.MessageDigest
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
        .addInterceptor { chain -> createParametersDefault(chain) }
        .addInterceptor(httpLoggingInterceptor).build()

}

fun createParametersDefault(chain: Interceptor.Chain): Response {
    val timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    var request = chain.request()
    val builder = request.url.newBuilder()

    builder.addQueryParameter("apikey", BuildConfig.API_PUBLIC)
        .addQueryParameter(
            "hash",
            HashGenerate.generate(timeStamp, BuildConfig.API_PRIVATE, BuildConfig.API_PUBLIC)
        )
        .addQueryParameter("ts", timeStamp.toString())

    request = request.newBuilder().url(builder.build()).build()
    return chain.proceed(request)
}

object HashGenerate {

    fun generate(timestamp: Long, privateKey: String, publicKey: String): String {
        return (timestamp.toString() + privateKey + publicKey).toMD5()
    }

    private fun String.toMD5(): String {
        val md = MessageDigest.getInstance("MD5")
        val digested = md.digest(toByteArray())
        return digested.joinToString("") { String.format("%02x", it) }
    }
}