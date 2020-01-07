package ru.ar4i.sqlearn.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.BaseFragment
import ru.ar4i.sqlearn.presentation.main.IRouter

class SplashFragment : BaseFragment() {

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null && activity is IRouter) {
            (activity as IRouter).navigateToApplication()
        }
    }

}
