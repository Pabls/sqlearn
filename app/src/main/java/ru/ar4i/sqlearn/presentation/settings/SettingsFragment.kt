package ru.ar4i.sqlearn.presentation.settings

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.BaseFragment
import ru.ar4i.sqlearn.presentation.main.IModeActivity

class SettingsFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_settings

    private var cbChangeMode: CheckBox? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cbChangeMode = view.findViewById(R.id.cb_change_mode)
        cbChangeMode?.setOnClickListener {
            activity?.let {
                if (it is IModeActivity) {
                    it.setDarkMode(cbChangeMode?.isChecked ?: false)
                }
            }
        }
    }
}
