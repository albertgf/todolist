package com.eirrok.core.database.datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.eirrok.core.database.AppDatabase
import com.eirrok.core.database.model.TaskEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.OffsetDateTime

class PersistenceTaskDataSourceTest {

    private lateinit var persistenceTaskDataSource: PersistenceTaskDataSource
    private lateinit var appDatabase: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        appDatabase = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
        persistenceTaskDataSource = appDatabase.taskDataSource()
    }

    @Test
    fun persistenceTaskDataSource_get_task_since_yesterday_is_empty() = runTest {
        val tasks = persistenceTaskDataSource.getAllSinceYesterday().first()
        Assert.assertEquals(0, tasks.size)
    }

    @Test
    fun persistenceTaskDataSource_insert_and_delete_task_should_get_empty_tasks() = runTest {
        val task = testTaskEntity()
        persistenceTaskDataSource.insertAll(task)
        val taskInserted = persistenceTaskDataSource.getAllSinceYesterday().first().first()
        persistenceTaskDataSource.delete(taskInserted)
        val tasks = persistenceTaskDataSource.getAllSinceYesterday().first()
        Assert.assertEquals(0, tasks.size)
    }

    private fun testTaskEntity() =
        TaskEntity(
            uid = 0,
            title = "title",
            repeat = false,
            remember = false,
            completed = false,
            date = OffsetDateTime.now()
        )
}