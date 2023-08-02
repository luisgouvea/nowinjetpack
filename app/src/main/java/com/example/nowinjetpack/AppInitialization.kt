package com.example.nowinjetpack

import org.koin.core.module.Module
import com.example.core.common.ModuleInitialization
import com.example.network.di.networkModule

class AppInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
//        return listOf(
//            networkModule,
//            repositoryModule,
//            viewModelModule
//        )
        return listOf(
            networkModule
        )
    }
}
