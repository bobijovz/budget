package com.bobijovz.kalupi.presentation.home

import com.bobijovz.data.repository.BudgetRepositoryImpl
import com.bobijovz.domain.repository.BudgetRepository
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object HomeModule {
    val dependencies = module {
        factory { FirebaseDatabase.getInstance() }
        factory<BudgetRepository> { BudgetRepositoryImpl(get()) }
        factory { com.bobijovz.domain.interactor.GetExpenses(get()) }
        factory { com.bobijovz.domain.interactor.GetIncome(get()) }
        viewModel { HomeViewModel(get(), get()) }
    }
}