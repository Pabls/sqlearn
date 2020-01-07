package ru.ar4i.sqlearn.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.presentation.splash.SplashFragmentDirections

class MainActivity : AppCompatActivity(), IRouter, IToolbarActivity {
    private var navController: NavController? = null
    private var vBottomNavigation: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
        initBottomNavigationView()
        checkState(savedInstanceState)
    }

    override fun navigateToApplication() {
        Thread(Runnable {
            Thread.sleep(4000L)
            runOnUiThread {
                val navDirections = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                navController?.navigate(navDirections)
                vBottomNavigation?.visibility = View.VISIBLE
            }
        }).start()
    }

    override fun onBackPressed() {
        val destination = navController?.currentDestination
        if (destination != null &&
            (destination.id == R.id.sectionsFragment || destination.id == R.id.settingsFragment)
        ) {
            finish()
            return
        }
        super.onBackPressed()
    }

    override fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.title  = getString(R.string.common_empty)
    }

    private fun initBottomNavigationView() {
        vBottomNavigation = findViewById(R.id.nav_menu)
        if (navController != null)
            vBottomNavigation?.setupWithNavController(navController!!)
    }

    private fun checkState(savedInstanceState: Bundle?) {
        val destination = navController?.currentDestination
        if (savedInstanceState != null && destination?.id != R.id.splashFragment) {
            vBottomNavigation?.visibility = View.VISIBLE
        } else {
            vBottomNavigation?.visibility = View.GONE
        }
    }
}
