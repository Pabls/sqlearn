package ru.ar4i.sqlearn.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import ru.ar4i.sqlearn.data.repositories.currentState.ICurrentStateRepository
import ru.ar4i.sqlearn.data.repositories.sections.ISectionsRepository

class SectionsViewModel(
    val stateRepository: ICurrentStateRepository,
    val sectionsRepository: ISectionsRepository,
    application: Application
) : AndroidViewModel(application) {

    sealed class State
}