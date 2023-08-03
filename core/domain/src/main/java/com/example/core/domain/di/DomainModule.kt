package com.example.core.domain.di


import com.example.core.domain.DeliveryUseCase
import org.koin.dsl.module

val domainModule = module {
    single { DeliveryUseCase(get()) }
    //single { DeliveryUseCase() }
}