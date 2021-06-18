package com.bobijovz.budget.presentation.home

import com.bobijovz.data.repository.BudgetRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeModule {
    val dependencies = module {
        factory<com.bobijovz.domain.BudgetRepository> { BudgetRepositoryImpl() }
        factory { com.bobijovz.domain.interactor.GetExpenses(get()) }
        viewModel { HomeViewModel(get()) }
    }
}