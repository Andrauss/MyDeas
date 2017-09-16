package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.facebook.login.LoginManager
import com.luizzabuscka.mydeas.R
import com.luizzabuscka.mydeas.prefs
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.support.v4.alert
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    prefs.logged = true
    configUi()
  }

  fun configUi() {
    fab.setOnClickListener {
      newIdea()
    }

    val toggle = ActionBarDrawerToggle(
        this, drawer_layout, toolbar, R.string.navigation_drawer_open,
        R.string.navigation_drawer_close)
    drawer_layout.addDrawerListener(toggle)
    toggle.syncState()

    nav_view.setNavigationItemSelectedListener(this)
      getSupportFragmentManager().beginTransaction().replace(R.id.flContent, IdeasFragment()).commit()
  }

  fun newIdea() {
    startActivity(Intent(this, IdeaMaintenanceActivity::class.java))
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
        fragment = AcceleratorsFragment()
      }
      R.id.nav_about -> {
        fragment = AboutFragment()
      }
      R.id.nav_logout -> {
          alert(getString(R.string.dialog_logout)) {
              yesButton {
                  prefs.logged = false
                  LoginManager.getInstance().logOut()
                  startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                  finish()
              }
              noButton {}
          }.show()
      }
    }

      if (fragment != null) {

                  getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit()

          item.setChecked(true)
          if (item.itemId != R.id.nav_home) {
              fab.hide()
              setTitle(item.title)
          } else {
              fab.show()
              setTitle(R.string.app_name)
          }
      }

    drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }
}
