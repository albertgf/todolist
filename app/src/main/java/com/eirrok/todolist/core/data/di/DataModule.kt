package com.eirrok.todolist.core.data.di

import com.eirrok.todolist.OFFLINE_FIRST_SCOPE
import com.eirrok.todolist.core.data.repository.OfflineFirstTaskRepository
import com.eirrok.todolist.core.data.repository.TaskRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<TaskRepository>(named(OFFLINE_FIRST_SCOPE)) { OfflineFirstTaskRepository(get()) }
}