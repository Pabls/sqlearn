package ru.ar4i.sqlearn.data.repositories.settings

import android.content.SharedPreferences

object SettingsRepository : ISettingsRepository {

    const val SORTING_STATE = "SORTING_STATE"
    const val FILTER_STATE = "FILTER_STATE"
    const val APP_MODE = "APP_MODE"
    private lateinit var prefs: SharedPreferences

    fun setSharedPreferences(prefs: SharedPreferences) {
        this.prefs = prefs
    }

    override suspend fun saveCurrentFilters(sortingState: String?, filterState: String?) {
        getEditor().putString(SORTING_STATE, sortingState).putString(FILTER_STATE, filterState)
            .commit()
    }

    override suspend fun getCurrentFilters(): Pair<String?, String?> =
        prefs.getString(SORTING_STATE, null) to prefs.getString(FILTER_STATE, null)

    override suspend fun saveMode(isDark: Boolean) {
        val mode = if (isDark) AppMode.Dark else AppMode.Light
        getEditor().putString(APP_MODE, mode.name).commit()
    }

    override suspend fun isDarkMode(): Boolean {
        val mode = prefs.getString(APP_MODE, AppMode.Light.name)
        return mode == AppMode.Dark.name
    }

    private fun getEditor() = prefs.edit()

    private enum class AppMode {
        Dark, Light
    }
}