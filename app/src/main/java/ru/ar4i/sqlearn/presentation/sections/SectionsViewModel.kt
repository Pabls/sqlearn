package ru.ar4i.sqlearn.presentation.sections

import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
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
        val job = GlobalScope.launch(Dispatchers.IO) {
            settingsInteractor.saveCurrentFilters(sortingType, filterType)
        }
        track(job)
    }

    fun getFilters() = sortingType to filterType

    private fun checkFilters() {
        val job = GlobalScope.launch(Dispatchers.IO) {
            val filters = async {
                settingsInteractor.getCurrentFilters()
            }
            sortingType = filters.await().first
            filterType = filters.await().second
        }
        track(job)
    }
}