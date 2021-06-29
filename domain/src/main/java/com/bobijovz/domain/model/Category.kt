package com.bobijovz.domain.model

data class Category(
    val categoryId: String,
    val categoryName: String,
    val categoryPlanned: Double = 0.0
)