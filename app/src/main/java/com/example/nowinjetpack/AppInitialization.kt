package com.example.nowinjetpack

import org.koin.core.module.Module
import com.example.core.common.ModuleInitialization
import com.example.core.data.di.dataModule
import com.example.nowinjetpack.core.network.di.networkModule
import com.example.nowinjetpack.marvel.di.marvelModule
import com.example.core.domain.di.domainModule

class AppInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
        return listOf(
            marvelModule,
            domainModule,
            dataModule,
            networkModule
        )
    }
}
