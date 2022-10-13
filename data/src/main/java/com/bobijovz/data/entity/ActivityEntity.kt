package com.bobijovz.data.entity

data class ActivityEntity(
    val id: String,
    val categoryId: String,
    val description: String,
    val price: Double
)

/*
@Entity
data class ActivityEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "category_id") val categoryId: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "price") val price: Double
)*/
