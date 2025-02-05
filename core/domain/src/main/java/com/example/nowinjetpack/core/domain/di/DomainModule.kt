package com.example.nowinjetpack.core.domain.di


import com.example.nowinjetpack.core.domain.DeliveryUseCase
import com.example.nowinjetpack.core.domain.SerieUseCase
import org.koin.dsl.module

val domainModule = module {
    single { DeliveryUseCase(get()) }
    single { SerieUseCase(get()) }
}