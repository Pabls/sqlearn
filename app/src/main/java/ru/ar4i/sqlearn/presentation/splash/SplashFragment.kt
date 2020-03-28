package ru.ar4i.sqlearn.presentation.splash

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.base.fragment.BaseVmFragment

class SplashFragment : BaseVmFragment<SplashViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_splash
    override val viewModel: Class<SplashViewModel>
        get() = SplashViewModel::class.java

    override fun initObservers() {
        vm.isDarkModeChecked.observe(viewLifecycleOwner, Observer {
            getModeActivity().setDarkMode(it)
            val navDirections =
                SplashFragmentDirections.actionSplashFragmentToNestedGraph()
            findNavController().navigate(navDirections)
        })
    }
}
