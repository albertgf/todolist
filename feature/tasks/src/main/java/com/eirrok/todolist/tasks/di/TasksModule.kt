package com.eirrok.todolist.tasks.di

import com.eirrok.todolist.tasks.ui.TodayViewModel
import org.koin.dsl.module

val taskModule = module {
    factory {  TodayViewModel(get(), get()) }
}