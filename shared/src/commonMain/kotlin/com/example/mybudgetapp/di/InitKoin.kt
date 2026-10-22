package com.example.mybudgetapp.di

import com.example.mybudgetapp.feature.overview.presentation.OverviewScreenViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { OverviewScreenViewModel() }
}

fun initKoin(
    configure: KoinApplication.() -> Unit = {},
) {
    startKoin {
        configure()
        modules(appModule)
    }
}