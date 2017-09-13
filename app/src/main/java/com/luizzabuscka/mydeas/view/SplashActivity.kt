package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.luizzabuscka.mydeas.R.layout
import com.luizzabuscka.mydeas.presentation.ISplashPresenter
import com.luizzabuscka.mydeas.presentation.SplashPresenter
import com.luizzabuscka.mydeas.utils.fadeIn
import com.luizzabuscka.mydeas.utils.putDropShadow
import com.luizzabuscka.mydeas.utils.startActivityWithFade
import kotlinx.android.synthetic.main.activity_login.ivLogo
import java.util.Timer
import kotlin.concurrent.schedule

class SplashActivity : AppCompatActivity(), ISplashActivity {

  val presenter : ISplashPresenter = SplashPresenter(this, this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_splash)

    ivLogo.putDropShadow()
    ivLogo.fadeIn(2200)

    presenter.downloadLogins()

  }

  override fun callNextActivity(intent: Intent) {
    Timer("schedule", true).schedule(3000) {
      startActivityWithFade(intent, true)
    }
  }
}
