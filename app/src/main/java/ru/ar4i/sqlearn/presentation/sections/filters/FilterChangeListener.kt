package ru.ar4i.sqlearn.presentation.sections.filters

interface FilterChangeListener {
    fun onSaveButtonClick(sortingType: String?, filterType: String?)
    fun onResetButtonClick()
}