package ru.ar4i.sqlearn.presentation.base.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val jobs = arrayListOf<Job>()

    protected fun <T> EventLiveData() = MutableLiveData<Event<T>>()

    protected fun track(job: Job) {
        jobs.add(job)
    }

    override fun onCleared() {
        if (jobs.isNotEmpty()) {
            jobs.forEach {
                if (it.isActive)
                    it.cancel()
            }
        }
        super.onCleared()
    }
}
