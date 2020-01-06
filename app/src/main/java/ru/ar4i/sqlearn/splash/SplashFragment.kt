package ru.ar4i.sqlearn.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.main.IRouter

class SplashFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SplashFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null && activity is IRouter) {
            (activity as IRouter).navigateToApplication()
        }
    }

}
