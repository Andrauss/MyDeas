package com.luizzabuscka.mydeas.interactors

import com.luizzabuscka.mydeas.model.Login

/**
 * Created by luizzabuscka on 02/08/17.
 */
interface ISplashInteractor {
  fun saveLogin(login: Login)
  fun downloadLogins()
}