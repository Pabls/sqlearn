package ru.ar4i.sqlearn.presentation.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.main.IToolbarActivity

open abstract class BaseToolbarFragment : BaseFragment() {

    private var tvTitle: TextView? = null
    private var toolbar: Toolbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.toolbar_title)
        tvTitle?.text = getTitle()
        toolbar = view.findViewById(R.id.toolbar)
    }

    abstract fun getTitle(): String

    protected fun showBackButton() {
        toolbar?.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
    }

    protected fun showMenu() {
        if (toolbar != null && activity != null && activity is IToolbarActivity) {
            setHasOptionsMenu(true)
            (activity!! as IToolbarActivity).setToolbar(toolbar!!)
        }
    }
}