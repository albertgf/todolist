package com.eirrok.todolist

import android.app.Application
import androidx.work.Configuration
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule)
        }
    }


    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            //.setMinimumLoggingLevel(if (BuildConfig.DEBUG) android.util.Log.DEBUG else android.util.Log.ERROR)
            .build()
}