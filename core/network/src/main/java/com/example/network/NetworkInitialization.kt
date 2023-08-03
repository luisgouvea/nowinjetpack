package com.example.network

import com.example.core.common.ModuleInitialization
import com.example.network.retrofit.RetrofitNijNetwork
import org.koin.core.module.Module
import org.koin.dsl.module


class NetworkInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
        return listOf(
            module {
                single { RetrofitNijNetwork(get()) }
                single<NijNetworkDataSource> { NijNetworkDataSourceImpl(get()) }



            }
        )
    }
}