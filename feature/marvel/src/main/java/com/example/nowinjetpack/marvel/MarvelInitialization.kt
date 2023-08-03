package com.example.nowinjetpack.marvel

import com.example.core.common.ModuleInitialization
import com.example.nowinjetpack.marvel.MarvelViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


class MarvelInitialization : ModuleInitialization() {
    override fun init(): List<Module> {
        return listOf(
            module {
                viewModel { MarvelViewModel(get()) }
            }
        )
    }
}