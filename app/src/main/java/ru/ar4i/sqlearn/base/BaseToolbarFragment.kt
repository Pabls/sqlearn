package ru.ar4i.sqlearn.base

import android.os.Bundle
import android.view.View
import android.widget.TextView
import ru.ar4i.sqlearn.R

open abstract class BaseToolbarFragment : BaseFragment() {

    private lateinit var tvTitle: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTitle = view.findViewById(R.id.toolbar_title)
        tvTitle.text = getString(getTitleId())
    }

    abstract fun getTitleId(): Int
}