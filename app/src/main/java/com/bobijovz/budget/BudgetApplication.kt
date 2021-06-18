package com.bobijovz.budget

import android.app.Application
import com.bobijovz.budget.presentation.home.HomeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BudgetApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BudgetApplication)
            modules(HomeModule.dependencies)
        }

    }


}