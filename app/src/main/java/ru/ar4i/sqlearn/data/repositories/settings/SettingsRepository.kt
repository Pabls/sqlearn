package ru.ar4i.sqlearn.data.repositories.settings

import android.content.SharedPreferences
import java.lang.Exception

object SettingsRepository : ISettingsRepository {

    const val SORTING_STATE = "SORTING_STATE"
    const val FILTER_STATE = "FILTER_STATE"
    const val APP_MODE = "APP_MODE"
    private lateinit var prefs: SharedPreferences

    fun setSharedPreferences(prefs: SharedPreferences) {
        this.prefs = prefs
    }

    override suspend fun saveCurrentFilters(sortingState: String?, filterState: String?) {
        try {
            getEditor().putString(SORTING_STATE, sortingState).putString(FILTER_STATE, filterState)
                .commit()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override suspend fun getCurrentFilters(): Pair<String?, String?> =
        try {
            prefs.getString(SORTING_STATE, null) to prefs.getString(FILTER_STATE, null)
        } catch (ex: Exception) {
            null to null
        }

    override suspend fun saveMode(isDark: Boolean) {
        try {
            val mode = if (isDark) AppMode.Dark else AppMode.Light
            getEditor().putString(APP_MODE, mode.name).commit()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    override suspend fun isDarkMode(): Boolean =
        try {
            val mode = prefs.getString(APP_MODE, AppMode.Light.name)
            mode == AppMode.Dark.name
        } catch (ex: Exception) {
            false
        }

    private fun getEditor() = prefs.edit()

    private enum class AppMode {
        Dark, Light
    }
}