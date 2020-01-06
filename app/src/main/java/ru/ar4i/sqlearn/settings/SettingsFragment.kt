package ru.ar4i.sqlearn.settings

import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.base.BaseFragment

class SettingsFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = SettingsFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_settings

}
