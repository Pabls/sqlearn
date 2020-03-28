package ru.ar4i.sqlearn.application.di.modules

import android.content.Context

object SharedPrefsModule {
    private const val PREFS_NAME = ""
    private val prefs = AppModule.provideApplication()
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun provideSharedPrefs() = prefs
}