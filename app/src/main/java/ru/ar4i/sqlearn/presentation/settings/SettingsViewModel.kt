package ru.ar4i.sqlearn.presentation.settings

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.ar4i.sqlearn.domain.ISettingsInteractor
import ru.ar4i.sqlearn.presentation.base.viewModel.BaseViewModel
import ru.ar4i.sqlearn.presentation.base.viewModel.Event

class SettingsViewModel(
    application: Application,
    private val settingsInteractor: ISettingsInteractor
) : BaseViewModel(application) {
    var isDarkModeChecked = EventLiveData<Boolean>()

    init {
        checkMode()
    }

    fun modeChanged(isDarkMode: Boolean) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                settingsInteractor.saveMode(isDarkMode)
            }
        }
    }

    private fun checkMode() {
        viewModelScope.launch {
            val isDarkMode = withContext(Dispatchers.IO) {
                settingsInteractor.isDarkMode()
            }
            isDarkModeChecked.value = Event(isDarkMode)
        }
    }
}