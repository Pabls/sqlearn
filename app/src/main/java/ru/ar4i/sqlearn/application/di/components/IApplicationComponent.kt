package ru.ar4i.sqlearn.application.di.components

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

interface IApplicationComponent {
    fun provideViewModelsFactory(bundle: Bundle? = null): ViewModelProvider.Factory
}