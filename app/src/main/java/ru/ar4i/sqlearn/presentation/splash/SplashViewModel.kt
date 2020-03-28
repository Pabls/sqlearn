package ru.ar4i.sqlearn.presentation.splash

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import ru.ar4i.sqlearn.domain.ISettingsInteractor
import ru.ar4i.sqlearn.presentation.base.viewModel.BaseViewModel

class SplashViewModel(
    application: Application,
    private val settingsInteractor: ISettingsInteractor
) : BaseViewModel(application) {
    var isDarkModeChecked = MutableLiveData<Boolean>()

    init {
        checkMode()
    }

    private fun checkMode() {
        val job = GlobalScope.launch(Dispatchers.Main) {
            val isDarkMode = async(Dispatchers.IO) {
                settingsInteractor.isDarkMode()
            }
            isDarkModeChecked.value = isDarkMode.await()
        }
        track(job)
    }
}