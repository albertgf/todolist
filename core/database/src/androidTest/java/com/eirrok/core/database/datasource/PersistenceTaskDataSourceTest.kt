package com.eirrok.core.database.datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.eirrok.core.database.AppDatabase
import org.junit.Before

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
}