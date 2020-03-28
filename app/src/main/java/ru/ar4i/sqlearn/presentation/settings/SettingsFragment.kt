package ru.ar4i.sqlearn.presentation.settings

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.Observer
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.fragment.BaseVmFragment
import ru.ar4i.sqlearn.presentation.main.IModeActivity

class SettingsFragment : BaseVmFragment<SettingsViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_settings

    override val viewModel: Class<SettingsViewModel>
        get() = SettingsViewModel::class.java

    private var cbChangeMode: CheckBox? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cbChangeMode = view.findViewById(R.id.cb_change_mode)

        cbChangeMode?.setOnCheckedChangeListener { _, isChecked ->
            getModeActivity().setDarkMode(isChecked)
            vm.modeChanged(isChecked)
        }
    }

    override fun initObservers() {
        vm.isDarkModeChecked.observeEvent { it?.let { cbChangeMode?.isChecked = it } }
    }
}
