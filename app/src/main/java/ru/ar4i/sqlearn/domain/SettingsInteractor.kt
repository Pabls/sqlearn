package ru.ar4i.sqlearn.domain

import ru.ar4i.sqlearn.data.repositories.settings.ISettingsRepository

class SettingsInteractor(private val settingsRepository: ISettingsRepository) :
    ISettingsInteractor {

    override suspend fun saveCurrentFilters(sortingState: String?, filterState: String?) {
        settingsRepository.saveCurrentFilters(sortingState, filterState)
    }

    override suspend fun getCurrentFilters(): Pair<String?, String?> =
        settingsRepository.getCurrentFilters()


    override suspend fun saveMode(isDark: Boolean) {
        settingsRepository.saveMode(isDark)
    }

    override suspend fun isDarkMode(): Boolean = settingsRepository.isDarkMode()
}