package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Activity
import com.bobijovz.domain.model.Category
import com.bobijovz.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow

class GetCategories(private val budgetRepository: BudgetRepository) {

    fun execute(): Flow<List<Category>> {
        return budgetRepository.getCategories()
    }
}