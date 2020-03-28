package ru.ar4i.sqlearn.application.di.components

import androidx.lifecycle.ViewModelProvider

interface IApplicationComponent {
    fun provideViewModelsFactory(): ViewModelProvider.Factory
}