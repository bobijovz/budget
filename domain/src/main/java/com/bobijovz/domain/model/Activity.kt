package com.bobijovz.domain.model

data class Activity(
    val id: String,
    val categoryId: String,
    val description: String,
    val type: String,
    val price: Double,
    val timestamp: Long)
