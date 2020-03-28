package ru.ar4i.sqlearn.presentation.splash

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
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
        viewModelScope.launch {
            val isDarkMode = withContext(Dispatchers.IO) {
                settingsInteractor.isDarkMode()
            }
            isDarkModeChecked.value = isDarkMode
        }
    }
}