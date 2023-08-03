package com.example.nowinjetpack.marvel.di


import com.example.nowinjetpack.marvel.MarvelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val marvelModule = module {
    viewModel { MarvelViewModel(get()) }
}