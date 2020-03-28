package ru.ar4i.sqlearn.application.di.modules

import ru.ar4i.sqlearn.data.repositories.settings.SettingsRepository
import ru.ar4i.sqlearn.data.repositories.settings.ISettingsRepository
import ru.ar4i.sqlearn.data.repositories.sections.ISectionsRepository
import ru.ar4i.sqlearn.data.repositories.sections.SectionsRepository

object RepositoriesModule {

    private var settingsRepository = SettingsRepository.also {
        it.setSharedPreferences(SharedPrefsModule.provideSharedPrefs())
    }

    private var sectionsRepository = SectionsRepository.also {
        it.setContext(AppModule.provideContext())
        it.setCompletedSectionsDao(DatabaseModule.provideCompletedSectionsDao())
    }

    fun provideSettingsRepository (): ISettingsRepository = settingsRepository

    fun provideSectionsRepository(): ISectionsRepository = sectionsRepository
}