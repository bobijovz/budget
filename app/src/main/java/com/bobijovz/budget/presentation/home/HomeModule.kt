package com.bobijovz.budget.presentation.home

import com.bobijovz.budget.data.BudgetRepositoryImpl
import com.bobijovz.budget.domain.BudgetRepository
import com.bobijovz.budget.domain.interactor.GetExpenses
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object HomeModule {
    val dependencies = module {
        factory<BudgetRepository> { BudgetRepositoryImpl() }
        factory { GetExpenses(get()) }
        viewModel { HomeViewModel(get()) }
    }
}