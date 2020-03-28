package ru.ar4i.sqlearn.application.di.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ar4i.sqlearn.application.di.modules.AppModule
import ru.ar4i.sqlearn.application.di.modules.InteractorsModule
import ru.ar4i.sqlearn.presentation.base.viewModel.EmptyViewModel
import ru.ar4i.sqlearn.presentation.sections.SectionsViewModel
import ru.ar4i.sqlearn.presentation.settings.SettingsViewModel
import ru.ar4i.sqlearn.presentation.splash.SplashViewModel

object ViewModelsFactory : ViewModelProvider.Factory {

    private val app = AppModule.provideApplication()
    private val interactorsModule = InteractorsModule

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            SettingsViewModel::class.java -> SettingsViewModel(
                app,
                interactorsModule.provideSettingsInteractor()
            )
            SplashViewModel::class.java -> SplashViewModel(
                app,
                interactorsModule.provideSettingsInteractor()
            )
            SectionsViewModel::class.java -> SectionsViewModel(
                app,
                interactorsModule.provideSettingsInteractor()
            )
            else -> EmptyViewModel(
                app
            )
        } as T
    }
}