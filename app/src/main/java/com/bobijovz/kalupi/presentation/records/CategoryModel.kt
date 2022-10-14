package com.bobijovz.kalupi.presentation.records

data class CategoryModel(
    val categoryId: String,
    val categoryName: String,
    val categoryPlanned: Double = 0.0
)