package com.eirrok.todolist.core.domain.di

import com.eirrok.todolist.OFFLINE_FIRST_SCOPE
import com.eirrok.todolist.core.domain.usecase.AddTaskUseCase
import com.eirrok.todolist.core.domain.usecase.GetTodayTasksUseCase
import com.eirrok.todolist.features.tasks.ui.TodayViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    factory { AddTaskUseCase(get(qualifier = named(OFFLINE_FIRST_SCOPE))) }
    factory { GetTodayTasksUseCase(get(qualifier = named(OFFLINE_FIRST_SCOPE))) }

    viewModel { TodayViewModel(get(), get()) }
}