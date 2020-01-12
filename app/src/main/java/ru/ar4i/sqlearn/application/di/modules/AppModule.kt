package ru.ar4i.sqlearn.application.di.modules

import android.app.Application
import android.content.Context

object AppModule {
    private lateinit var app: Application

    fun setApplication(context: Application) {
        this.app = context
    }

    fun provideContext(): Context = app

    fun provideApplication(): Application = app
}