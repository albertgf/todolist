package com.eirrok.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eirrok.core.database.datasource.PersistenceTaskDataSource
import com.eirrok.core.database.model.TaskEntity

@Database(entities = [TaskEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract  class AppDatabase : RoomDatabase() {
    abstract  fun taskDataSource(): PersistenceTaskDataSource

    companion object{
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            androidx.room.Room.databaseBuilder(context, AppDatabase::class.java, "task.db")
                .build()

        //TODO populate database with dummy data
        /* .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>()
                                    .setInputData(workDataOf(KEY_FILENAME to PLANT_DATA_FILENAME))
                                    .build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()8*/
    }
}