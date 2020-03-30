package ru.ar4i.sqlearn.presentation.details

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import ru.ar4i.sqlearn.presentation.base.viewModel.BaseViewModel
import ru.ar4i.sqlearn.presentation.details.DetailsFragment.Companion.ARG_SCREEN_NAME

class DetailsViewModel(application: Application, private val bundle: Bundle?) :
    BaseViewModel(application) {

    var title = MutableLiveData<String>()

    init {
        title.value = bundle?.getString(ARG_SCREEN_NAME)
    }
}