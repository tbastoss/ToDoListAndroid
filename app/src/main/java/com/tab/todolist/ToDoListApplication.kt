package com.tab.todolist

import android.app.Application
import com.tab.todolist.di.useCaseModule
import com.tab.todolist.di.viweModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ToDoListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger( Level.DEBUG )
            androidContext(this@ToDoListApplication)
            modules(listOf(viweModelModule, useCaseModule))
        }
    }

}