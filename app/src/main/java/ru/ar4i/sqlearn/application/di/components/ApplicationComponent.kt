package ru.ar4i.sqlearn.application.di.components

import android.content.Context
import ru.ar4i.sqlearn.application.di.modules.AppModule
import ru.ar4i.sqlearn.presentation.sections.SectionsFragment

class ApplicationComponent:
    IApplicationComponent {

    constructor(context: Context){
        AppModule.setContext(context)
    }

    private constructor()

    override fun inject(sectionsFragment: SectionsFragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}