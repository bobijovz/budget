package com.bobijovz.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bobijovz.data.dao.RecordDao
import com.bobijovz.data.entity.RecordDbEntity

@Database(
    entities = [RecordDbEntity::class],
    version = 1
)

abstract class KalupiDatabase : RoomDatabase() {
    abstract fun recordDao() : RecordDao
}