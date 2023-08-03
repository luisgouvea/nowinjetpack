package com.example.nowinjetpack

import org.koin.core.module.Module
import com.example.core.common.ModuleInitialization
import com.example.core.data.di.dataModule
import com.example.network.di.networkModule
import com.example.nowinjetpack.marvel.di.marvelModule
import com.example.core.domain.di.domainModule

class AppInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
//        return listOf(
//            networkModule,
//            repositoryModule,
//            viewModelModule
//        )
        return listOf(
            networkModule,
            dataModule,
            domainModule,
            marvelModule
        )


//        networkModule,
//        userPreferenceModule,
//        repositoryModule,
//        viewModelModule,
//        otherModule
    }
}
