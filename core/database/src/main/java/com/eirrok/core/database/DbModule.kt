package com.eirrok.core.database

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "todo-list-db").build() }
    single { get<AppDatabase>().taskDao() }
}