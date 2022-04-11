package com.bobijovz.kalupi.presentation.activities

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ActivitiesModule {
    val dependencies = module {
        factory { com.bobijovz.domain.interactor.GetActivities(get()) }
        factory { com.bobijovz.domain.interactor.GetCategories(get()) }
        viewModel { ActivitiesViewModel(get(), get()) }
    }
}