package com.bobijovz.data.dao

import androidx.room.*
import com.bobijovz.data.entity.RecordDbEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface RecordDao {

    @Query("SELECT * FROM RecordDbEntity ORDER BY `timestamp` DESC")
    fun getAll(): Flow<List<RecordDbEntity>>

    @Query("SELECT * FROM RecordDbEntity WHERE id = :id")
    fun getMovie(id: Int): Flow<RecordDbEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg movieDbEntity: RecordDbEntity): List<Long>

//    @Update
//    fun update(vararg recordDbEntity: RecordDbEntity)

    @Delete
    fun delete(movieDbEntity: RecordDbEntity)

}