package ru.ar4i.sqlearn.application.di.modules

import ru.ar4i.sqlearn.data.repositories.currentState.CurrentStateRepository
import ru.ar4i.sqlearn.data.repositories.currentState.ICurrentStateRepository
import ru.ar4i.sqlearn.data.repositories.sections.ISectionsRepository
import ru.ar4i.sqlearn.data.repositories.sections.SectionsRepository

object RepositoriesModule {

    private var currentStateRepository = CurrentStateRepository

    private var sectionsRepository = SectionsRepository.also {
        it.setContext(AppModule.provideContext())
        it.setCompletedSectionsDao(DatabaseModule.provideCompletedSectionsDao())
    }

    fun provideCurrentStateRepository(): ICurrentStateRepository = currentStateRepository

    fun provideSectionsRepository(): ISectionsRepository = sectionsRepository
}