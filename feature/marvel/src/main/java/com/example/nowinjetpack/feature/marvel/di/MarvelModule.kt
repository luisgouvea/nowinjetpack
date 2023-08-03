package com.example.nowinjetpack.feature.marvel.di


import com.example.nowinjetpack.feature.marvel.MarvelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marvelModule = module {
    viewModel { MarvelViewModel(get()) }
}