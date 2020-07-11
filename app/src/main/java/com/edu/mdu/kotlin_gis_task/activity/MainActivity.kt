package com.edu.mdu.kotlin_gis_task.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.edu.mdu.kotlin_gis_task.R
import com.edu.mdu.kotlin_gis_task.fragments.HomeFragment
import com.edu.mdu.kotlin_gis_task.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val activity = this@MainActivity
    private val fragmentManager = supportFragmentManager
    private val profileFragment = ProfileFragment()
    private val homeFragment = HomeFragment()
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    private var PRIVATE_MODE = 0
    private val PREF_NAME = "PREFERENCE_NAME"
    var userNameStr: String =""
    var emailStr: String  = ""
    var phoneStr: String  = ""
    var passStr: String  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        frameLayout = findViewById(R.id.myFragment)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.myFragment, homeFragment)
        fragmentTransaction.commit()

        val sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val mlastname = sharedPreferences.getString("regName","").toString();
        emailStr= sharedPreferences.getString("regEmail","").toString();
        phoneStr= sharedPreferences.getString("regPhone","").toString();
        passStr= sharedPreferences.getString("regPass","").toString();

        d("daniel", "savedEmailAddress is: $mlastname")
        d("daniel", "savedEmailAddress is: $emailStr")

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {

//                val intent = Intent(this, ProfileActivity::class.java)
//                startActivity(intent)

                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.myFragment, profileFragment)
                fragmentTransaction.commit()
            }
            R.id.nav_home -> {
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.myFragment, homeFragment)
                fragmentTransaction.commit()
            }

            R.id.nav_logout -> {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
