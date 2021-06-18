package com.bobijovz.budget.domain

data class Category(
    val categoryid: String,
    val categoryName: String,
    val categoryPlanned: Double = 0.0
)