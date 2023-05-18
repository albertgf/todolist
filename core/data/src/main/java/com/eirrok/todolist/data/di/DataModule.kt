package com.eirrok.todolist.data.di

import com.eirrok.todolist.data.repository.TaskRepository
import com.eirrok.todolist.data.repository.OfflineFirstTaskRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<TaskRepository>(named(OFFLINE_FIRST_SCOPE)) { OfflineFirstTaskRepository(get()) }
}