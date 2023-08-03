package com.example.core.domain

import com.example.core.common.ModuleInitialization
import com.example.core.data.mapper.DeliveriesMapper
import com.example.core.data.repository.DeliveriesRepository
import com.example.core.data.repository.DeliveriesRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module


class DomainInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
        return listOf(
            module {
                single { DeliveryUseCase(get()) }
            }
        )
    }
}