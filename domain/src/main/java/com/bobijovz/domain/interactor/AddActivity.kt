package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.model.Category
import com.bobijovz.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip

class AddActivity(private val data: Activity, private val budgetRepository: BudgetRepository) {

    fun execute(): Unit {
        return budgetRepository.addActivity(data)
    }
}