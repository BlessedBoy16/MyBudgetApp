package com.example.mybudgetapp.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    // Здесь будем регистрировать зависимости.

}

fun initKoin(
    configure: KoinApplication.() -> Unit = {},
) {
    startKoin {
        configure()
        modules(appModule)
    }
}