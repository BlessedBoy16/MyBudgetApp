package com.example.mybudgetapp

import android.app.Application
import com.example.mybudgetapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BudgetApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BudgetApplication)
        }
    }
}
