package com.bobijovz.domain.interactor

import com.bobijovz.domain.model.Record
import com.bobijovz.domain.model.Category
import com.bobijovz.domain.repository.BudgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip

class GetRecords(private val budgetRepository: BudgetRepository) {

    fun execute(): Flow<List<Record>> {
        return budgetRepository.getCategories()
            .zip(budgetRepository.getRecords()) { categories, records ->
                val categoryList = mutableMapOf<String, Category>()
                categories.map { item ->
                    categoryList += item.categoryId to item
                }

                records.map { record ->
                     Record(
                        id = record.id,
                        categoryId = categoryList[record.categoryId]?.categoryName ?: "",
                        description = record.description,
                        type = record.type,
                        price = record.price,
                        timestamp = record.timestamp
                    )
                }
            }
    }
}