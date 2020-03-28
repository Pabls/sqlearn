package ru.ar4i.sqlearn.application.di.modules

import ru.ar4i.sqlearn.domain.ISettingsInteractor
import ru.ar4i.sqlearn.domain.SettingsInteractor

object InteractorsModule {
    fun provideSettingsInteractor(): ISettingsInteractor =
        SettingsInteractor(RepositoriesModule.provideSettingsRepository())
}