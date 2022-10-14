package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Record
import com.bobijovz.domain.repository.BudgetRepository

class AddRecord(private val data: Record, private val budgetRepository: BudgetRepository) {

    fun execute(): Unit {
        return budgetRepository.addRecord(data)
    }
}