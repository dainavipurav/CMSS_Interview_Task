package com.android.cmssinterviewtask.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.cmssinterviewtask.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), AppBarConfiguration.OnNavigateUpListener {

    private lateinit var mDrawerLayoutMain: DrawerLayout
    private lateinit var mConstraintLayoutMain: ConstraintLayout
    private lateinit var mToolbarMain: androidx.appcompat.widget.Toolbar
    private lateinit var mBottomNavigationViewMain: BottomNavigationView
    private lateinit var mMenuInflater: MenuInflater
    private lateinit var mNavHostFragmentMain: NavHostFragment
    private lateinit var mNavControllerMain: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var mDrawerNavigationViewMain: NavigationView
    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDrawerLayoutMain = findViewById(R.id.drawerLayoutMain)

        mConstraintLayoutMain = findViewById(R.id.constraintLayoutMain)

        mToolbarMain = findViewById(R.id.toolbarMain)
        mBottomNavigationViewMain = findViewById(R.id.bottomNavigationViewMain)
        mDrawerNavigationViewMain = findViewById(R.id.drawerNavigationViewMain)

        setSupportActionBar(mToolbarMain)

        mDrawerToggle = ActionBarDrawerToggle(
            this,
            mDrawerLayoutMain,
            mToolbarMain,
            R.string.text_string_open,
            R.string.text_string_close
        )

        mDrawerLayoutMain.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

        mNavHostFragmentMain =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        mNavControllerMain = mNavHostFragmentMain.navController

        mDrawerNavigationViewMain.setupWithNavController(mNavControllerMain)

        mAppBarConfiguration = AppBarConfiguration(mNavControllerMain.graph, mDrawerLayoutMain)

        mAppBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.favoritesFragment,
                R.id.teamFragment,
                R.id.approvalsFragment,
                R.id.notificationsFragment
            )
        )
        setupActionBarWithNavController(mNavControllerMain, mAppBarConfiguration)

        mBottomNavigationViewMain.setOnNavigationItemSelectedListener {
            Toast.makeText(this@MainActivity, "You Clicked ${it.title}", Toast.LENGTH_SHORT).show()
            when (it.itemId) {
                R.id.favoritesFragment -> {
                    mNavControllerMain.navigate(R.id.favoritesFragment)
                }
                R.id.teamFragment -> {
                    mNavControllerMain.navigate(R.id.teamFragment)
                }
                R.id.approvalsFragment -> {
                    mNavControllerMain.navigate(R.id.approvalsFragment)
                }
                R.id.notificationsFragment -> {
                    mNavControllerMain.navigate(R.id.notificationsFragment)
                }
            }
            true
        }

        mDrawerNavigationViewMain.setNavigationItemSelectedListener {
            Toast.makeText(this@MainActivity, "You Clicked ${it.title}", Toast.LENGTH_SHORT).show()

            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        mMenuInflater = menuInflater
        mMenuInflater.inflate(R.menu.appbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this@MainActivity, "You Clicked ${item.title}", Toast.LENGTH_SHORT).show()
        mDrawerLayoutMain.closeDrawer(mDrawerNavigationViewMain)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavControllerMain.navigateUp(mAppBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (mDrawerLayoutMain.isDrawerOpen(GravityCompat.START)){
            mDrawerLayoutMain.closeDrawer(GravityCompat.START)
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
}
