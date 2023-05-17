package com.eirrok.todolist

import com.eirrok.todolist.core.data.di.dataModule
import com.eirrok.core.database.databaseModule
import com.eirrok.todolist.core.domain.di.domainModule
import org.koin.dsl.module

const val OFFLINE_FIRST_SCOPE = "OFFLINE_FIRST_SCOPE"
const val NETWORK_SCOPE = "NETWORK_SCOPE"
const val MEMORY_SCOPE = "MEMORY_SCOPE"


val appModule = module {
    includes(com.eirrok.core.database.databaseModule)
    includes(dataModule)
    includes(domainModule)
}

