package ru.ar4i.sqlearn.presentation.sections

import android.app.Application
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import ru.ar4i.sqlearn.domain.ISettingsInteractor
import ru.ar4i.sqlearn.presentation.base.viewModel.BaseViewModel

class SectionsViewModel(
    application: Application,
    private val settingsInteractor: ISettingsInteractor
) : BaseViewModel(application) {

    private var sortingType: String? = null
    private var filterType: String? = null

    init {
        checkFilters()
    }

    fun setFilters(sortingType: String?, filterType: String?) {
        this.sortingType = sortingType
        this.filterType = filterType
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                settingsInteractor.saveCurrentFilters(sortingType, filterType)
            }
        }
    }

    fun getFilters() = sortingType to filterType

    private fun checkFilters() {
        viewModelScope.launch {
            val (sorting, filters) = withContext(Dispatchers.IO) {
                settingsInteractor.getCurrentFilters()
            }
            sortingType = sorting
            filterType = filters
        }
    }
}