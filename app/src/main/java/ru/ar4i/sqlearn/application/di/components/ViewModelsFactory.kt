package ru.ar4i.sqlearn.application.di.components

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.ar4i.sqlearn.application.di.modules.AppModule
import ru.ar4i.sqlearn.application.di.modules.InteractorsModule
import ru.ar4i.sqlearn.presentation.base.viewModel.EmptyViewModel
import ru.ar4i.sqlearn.presentation.details.DetailsViewModel
import ru.ar4i.sqlearn.presentation.quiz.QuizViewModel
import ru.ar4i.sqlearn.presentation.sections.SectionsViewModel
import ru.ar4i.sqlearn.presentation.settings.SettingsViewModel
import ru.ar4i.sqlearn.presentation.splash.SplashViewModel

object ViewModelsFactory : ViewModelProvider.Factory {

    private val app = AppModule.provideApplication()
    private val interactorsModule = InteractorsModule
    private var bundle: Bundle? = null

    fun setBundle(bundle: Bundle? = null) {
        this.bundle = bundle
    }

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
            DetailsViewModel::class.java -> DetailsViewModel(app, bundle)
            QuizViewModel::class.java -> QuizViewModel(app, bundle)
            else -> EmptyViewModel(app)
        } as T
    }
}