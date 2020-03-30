package ru.ar4i.sqlearn.presentation.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.fragment.BaseVmFragment

class DetailsFragment : BaseVmFragment<DetailsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_details
    override val viewModel: Class<DetailsViewModel>
        get() = DetailsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBackButton()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    companion object {
        const val ARG_SCREEN_NAME = "screenName"
    }

    override fun initObservers() {
        vm.title.observe(viewLifecycleOwner, Observer { setTitle(it) })
    }
}
