package ru.ar4i.sqlearn.application

import android.app.Application
import ru.ar4i.sqlearn.application.di.components.ApplicationComponent
import ru.ar4i.sqlearn.application.di.components.IApplicationComponent

class App : Application() {

    companion object {
        lateinit var applicationComponent: IApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ApplicationComponent(this)
    }
}