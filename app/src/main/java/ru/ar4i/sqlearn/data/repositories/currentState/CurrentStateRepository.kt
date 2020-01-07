package ru.ar4i.sqlearn.data.repositories.currentState

object CurrentStateRepository : ICurrentStateRepository {

    private var sortingState: String? = null
    private var filterState: String? = null

    override fun saveCurrentFilters(sortingState: String?, filterState: String?) {
        this.sortingState = sortingState
        this.filterState = filterState
    }

    override fun getCurrnetState(): Pair<String?, String?> = sortingState to filterState
}