package ru.ar4i.sqlearn.application.di.components

import android.app.Application
import ru.ar4i.sqlearn.application.di.modules.AppModule
import ru.ar4i.sqlearn.presentation.sections.SectionsFragment

class ApplicationComponent:
    IApplicationComponent {

    constructor(application: Application){
        AppModule.setApplication(application)
    }

    private constructor()

    override fun inject(sectionsFragment: SectionsFragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}