package ru.ar4i.sqlearn.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.ar4i.sqlearn.R

class MainActivity : AppCompatActivity(), IToolbarActivity {
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
    }

    override fun onBackPressed() {
        val destination = navController?.currentDestination
        if (checkCurrentDestination(destination)) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    override fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.common_empty)
    }

    private fun initBottomNavigationView() {
        vBottomNavigation = findViewById(R.id.nav_menu)
        navController?.let { controller ->
            vBottomNavigation?.let { navigation ->
                navigation.setupWithNavController(controller)

                controller.addOnDestinationChangedListener { _, destination, _ ->
                    navigation.visibility =
                        if (destination.id != R.id.splashFragment) {
                            View.VISIBLE
                        } else {
                            View.GONE
                        }
                }
            }
        }
    }

    private fun checkCurrentDestination(destination: NavDestination?) =
        destination != null &&
                destination.run {
                    id == R.id.sectionsFragment || id == R.id.settingsFragment || id == R.id.homeFragment
                }

}
