package com.luizzabuscka.mydeas.presentation

/**
 * Created by luizzabuscka on 02/08/17.
 */
interface ISplashPresenter {
  fun downloadLogins()
  fun verifyLogged() : Boolean
  fun callNextActivity()
}