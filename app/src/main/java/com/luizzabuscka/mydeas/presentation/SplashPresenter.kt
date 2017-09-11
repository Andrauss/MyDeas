package com.luizzabuscka.mydeas.presentation

import android.content.Context
import android.content.Intent
import com.luizzabuscka.mydeas.interactors.ISplashInteractor
import com.luizzabuscka.mydeas.interactors.SplashInteractor
import com.luizzabuscka.mydeas.view.ISplashActivity
import com.luizzabuscka.mydeas.view.LoginActivity

/**
 * Created by luizzabuscka on 02/08/17.
 */
class SplashPresenter(val context: Context, val activity: ISplashActivity) : ISplashPresenter {

  val interactor : ISplashInteractor = SplashInteractor(this, context)

  override fun callNextActivity() {
    if (!verifyLogged()) {
      activity.callNextActivity(Intent(context, LoginActivity::class.java))
    }
  }

  override fun downloadLogins() {
    if (verifyLogged()) {
      callNextActivity()
    } else {
      interactor.downloadLogins()
    }
  }

  override fun verifyLogged() : Boolean {
    return false
  }

}