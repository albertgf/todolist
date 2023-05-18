package com.eirrok.todolist

import com.eirrok.core.domain.di.domainModule
import com.eirrok.todolist.data.di.dataModule
import com.eirrok.todolist.features.tasks.di.taskModule
import org.koin.dsl.module

val appModule = module {
    includes(com.eirrok.core.database.databaseModule)
    includes(dataModule)
    includes(domainModule)
    includes(taskModule)
}

