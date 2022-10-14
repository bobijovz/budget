package com.bobijovz.domain.repository

import com.bobijovz.domain.model.Record
import com.bobijovz.domain.model.Category
import kotlinx.coroutines.flow.Flow


interface BudgetRepository {
    fun getRecords() : Flow<List<Record>>
    fun getCategories() : Flow<List<Category>>
    fun addRecord(data: Record)
}