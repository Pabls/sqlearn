package ru.ar4i.sqlearn.data.repositories.currentState

interface ICurrentStateRepository {
    fun saveCurrentFilters(sortingState: String?, filterState: String?)
    fun getCurrnetState(): Pair<String?, String?>
}