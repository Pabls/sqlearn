package ru.ar4i.sqlearn.application.di.components

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import ru.ar4i.sqlearn.application.di.modules.AppModule

class ApplicationComponent :
    IApplicationComponent {
    private constructor()

    constructor(application: Application) {
        AppModule.setApplication(application)
    }

    override fun provideViewModelsFactory(): ViewModelProvider.Factory = ViewModelsFactory
}