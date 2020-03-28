package ru.ar4i.sqlearn.presentation.base.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.ar4i.sqlearn.application.App
import ru.ar4i.sqlearn.presentation.base.viewModel.BaseViewModel
import ru.ar4i.sqlearn.presentation.base.viewModel.Event

abstract class BaseVmFragment<V : BaseViewModel> : BaseFragment() {

    abstract val viewModel: Class<V>
    protected lateinit var vm: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this, App.applicationComponent.provideViewModelsFactory())
            .get(viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    protected inline fun <T> LiveData<Event<T>>.observeEvent(crossinline observer: (T?) -> Unit) =
        this.observe(
            viewLifecycleOwner,
            Observer<Event<T>> { t -> t.getContentIfNotHandled()?.apply { observer.invoke(this) } })

    abstract fun initObservers()
}