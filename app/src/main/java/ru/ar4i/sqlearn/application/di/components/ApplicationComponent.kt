package ru.ar4i.sqlearn.application.di.components

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.ar4i.sqlearn.application.di.modules.AppModule

class ApplicationComponent :
    IApplicationComponent {
    private constructor()

    constructor(application: Application) {
        AppModule.setApplication(application)
    }

    override fun provideViewModelsFactory(bundle: Bundle?): ViewModelProvider.Factory =
        ViewModelsFactory.also { it.setBundle(bundle) }
}