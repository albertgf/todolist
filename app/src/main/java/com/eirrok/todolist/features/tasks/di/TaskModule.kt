package com.eirrok.todolist.features.tasks.di

import com.eirrok.todolist.features.tasks.ui.TodayViewModel
import org.koin.dsl.module

val taskModule = module {
    factory {  TodayViewModel(get(), get())}
}