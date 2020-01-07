package ru.ar4i.sqlearn.presentation.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.BaseToolbarFragment

class DetailsFragment : BaseToolbarFragment() {

    companion object {
        private const val ARG_SCREEN_NAME = "screenName"
    }

    private var screenName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            screenName = it.getString(ARG_SCREEN_NAME)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBackButton()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_details, container, false)

    override fun getLayoutId(): Int = R.layout.fragment_details

    override fun getTitle(): String = screenName ?: getString(R.string.common_empty)

}
