package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.prefs
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    prefs.logged = true
    configUi()
  }

  fun configUi() {
    fab.setOnClickListener { view ->
      newIdea()
    }

    val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close)
    drawer_layout.addDrawerListener(toggle)
    toggle.syncState()

    nav_view.setNavigationItemSelectedListener(this)
  }

  fun newIdea() {
    startActivity(Intent(this, NewIdeaActivity::class.java))
  }

  override fun onBackPressed() {
    if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
      drawer_layout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }


  override fun onNavigationItemSelected(item: MenuItem): Boolean {

    var fragment: Fragment? = null

    when (item.itemId) {
      R.id.nav_home -> {
        fragment = IdeasFragment()
      }
      R.id.nav_acelerators -> {

      }
      R.id.nav_map -> {

      }
      R.id.nav_about -> {

      }
      R.id.nav_logout -> {

      }
    }

    var fragmentManager = getSupportFragmentManager()
    fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()

    item.setChecked(true)
    if (item.itemId != R.id.nav_home) setTitle(item.title)

    drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }
}
