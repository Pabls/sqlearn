package ru.ar4i.sqlearn.application.di.components

import ru.ar4i.sqlearn.presentation.sections.SectionsFragment

interface IApplicationComponent {
    fun inject(sectionsFragment: SectionsFragment)
}