package ru.ar4i.sqlearn.menu

import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.base.BaseFragment

class MenuFragment : BaseFragment() {

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment()
    }

    override fun getLayoutId(): Int = R.layout.fragment_menu
}
