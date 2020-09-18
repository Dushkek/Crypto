package by.adush.cryptocurrency.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import by.adush.cryptocurrency.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        actionBar?.setHomeButtonEnabled(true)
        navController = Navigation.findNavController(this, R.id.navigation_host_fragment)

        bottom_navigation.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.filter_item,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.home -> {
                super.onBackPressed()
                return true
            }
            R.id.filter -> {
                val navController =
                    Navigation.findNavController(this, R.id.navigation_host_fragment)
                navController.navigate(R.id.filterFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}


