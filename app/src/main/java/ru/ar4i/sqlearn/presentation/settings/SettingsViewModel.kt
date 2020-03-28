package ru.ar4i.sqlearn.presentation.settings

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
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
        val job = GlobalScope.launch(Dispatchers.IO) {
            settingsInteractor.saveMode(isDarkMode)
        }
        track(job)
    }

    private fun checkMode() {
        val job = GlobalScope.launch(Dispatchers.Main) {
            val isDarkMode = async(Dispatchers.IO) {
                settingsInteractor.isDarkMode()
            }
            isDarkModeChecked.value = Event(isDarkMode.await())
        }
        track(job)
    }
}