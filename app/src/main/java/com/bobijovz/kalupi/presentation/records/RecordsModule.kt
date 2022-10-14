package com.bobijovz.kalupi.presentation.records

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object RecordsModule {
    val dependencies = module {
        factory { com.bobijovz.domain.interactor.GetRecords(get()) }
        factory { com.bobijovz.domain.interactor.GetCategories(get()) }
        viewModel { RecordsViewModel(get(), get()) }
    }
}