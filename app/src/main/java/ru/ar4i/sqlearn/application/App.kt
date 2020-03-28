package ru.ar4i.sqlearn.application

import android.app.Application
import com.facebook.stetho.Stetho
import ru.ar4i.sqlearn.BuildConfig
import ru.ar4i.sqlearn.application.di.components.ApplicationComponent
import ru.ar4i.sqlearn.application.di.components.IApplicationComponent

class App : Application() {

    companion object {
        lateinit var applicationComponent: IApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = ApplicationComponent(this)
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}