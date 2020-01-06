package ru.ar4i.sqlearn.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ar4i.sqlearn.R
import ru.ar4i.sqlearn.splash.SplashFragmentDirections

class MainActivity : AppCompatActivity(), IRouter {
    private lateinit var navController: NavController
    private lateinit var vBottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        )
        initBottomNavigationView()
    }

    override fun navigateToApplication() {
        Thread(Runnable {
            Thread.sleep(4000L)
            runOnUiThread {
                val navDirections = SplashFragmentDirections.actionSplashFragmentToMenuFragment()
                navController.navigate(navDirections)
                vBottomNavigation.visibility = View.VISIBLE
            }
        }).start()
    }

    override fun onBackPressed() {
        val destination = navController.currentDestination
        if (destination != null &&
            (destination.id == R.id.menuFragment || destination.id == R.id.settingsFragment)
        ) {
            finish()
            return
        }
        super.onBackPressed()
    }

    private fun initBottomNavigationView() {
        vBottomNavigation = findViewById(R.id.nav_menu)
        vBottomNavigation.setupWithNavController(navController)

    }
}
