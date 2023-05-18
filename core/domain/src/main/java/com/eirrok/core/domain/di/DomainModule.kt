package com.eirrok.core.domain.di

import com.eirrok.core.domain.usecase.AddTaskUseCase
import com.eirrok.core.domain.usecase.GetTodayTasksUseCase
import com.eirrok.todolist.data.di.OFFLINE_FIRST_SCOPE
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    factory { AddTaskUseCase(get(qualifier = named(OFFLINE_FIRST_SCOPE))) }
    factory { GetTodayTasksUseCase(get(qualifier = named(OFFLINE_FIRST_SCOPE))) }
}