package ru.ar4i.sqlearn.data.repositories.settings

interface ISettingsRepository {
    suspend fun saveCurrentFilters(sortingState: String?, filterState: String?)
    suspend fun getCurrentFilters(): Pair<String?, String?>
    suspend fun saveMode(isDark: Boolean)
    suspend fun isDarkMode(): Boolean
}