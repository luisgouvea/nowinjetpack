package com.example.core.data

import com.example.core.common.ModuleInitialization
import com.example.core.data.mapper.DeliveriesMapper
import com.example.core.data.repository.DeliveriesRepository
import com.example.core.data.repository.DeliveriesRepositoryImpl
import com.example.network.NijNetworkDataSource
import com.example.network.NijNetworkDataSourceImpl
import com.example.network.retrofit.RetrofitNijNetwork
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


class DataInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
        return listOf(
            module {
                single { DeliveriesMapper() }
                single<DeliveriesRepository> { DeliveriesRepositoryImpl(get(), get()) }

            }
        )
    }
}