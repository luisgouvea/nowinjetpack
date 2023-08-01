package com.example.nowinjetpack

import com.example.common.modules.ModuleInitialization
import org.koin.core.module.Module
import com.example.base.network.module.networkModule

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
