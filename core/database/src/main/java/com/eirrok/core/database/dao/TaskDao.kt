package com.eirrok.core.database.dao

import androidx.room.*
import com.eirrok.core.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task WHERE strftime('%s', datetime(date)) >= strftime('%s', datetime('now', '-1 day'))")
    fun getAllSinceYesterday(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg tasks: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)
}