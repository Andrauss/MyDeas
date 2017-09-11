package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.luizzabuscka.mydeas.R.layout
import com.luizzabuscka.mydeas.presentation.ISplashPresenter
import com.luizzabuscka.mydeas.presentation.SplashPresenter
import java.util.Timer
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity(), ISplashActivity {

  val presenter : ISplashPresenter = SplashPresenter(this, this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_splash)
    presenter.downloadLogins()

  }

  override fun callNextActivity(intent: Intent) {
    Timer("schedule", true).schedule(3000) {
      startActivity(intent)
      finish()
    }
  }
}
