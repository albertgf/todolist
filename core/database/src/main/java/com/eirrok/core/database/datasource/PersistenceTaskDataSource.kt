package com.eirrok.core.database.datasource

import androidx.room.*
import com.eirrok.core.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersistenceTaskDataSource {
    @Query("SELECT * FROM task WHERE strftime('%s', datetime(date)) >= strftime('%s', datetime('now', '-1 day'))")
    fun getAllSinceYesterday(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg tasks: TaskEntity)

    @Delete
    fun delete(task: TaskEntity)
}