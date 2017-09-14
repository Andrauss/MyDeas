package com.luizzabuscka.mydeas.interactors

import android.content.Context
import com.luizzabuscka.mydeas.database.LoginDAO
import com.luizzabuscka.mydeas.interactors.interfaces.ISplashInteractor
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.presentation.interfaces.ISplashPresenter
import com.luizzabuscka.mydeas.services.Factory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by luizzabuscka on 02/08/17.
 */
class SplashInteractor(val presenter: ISplashPresenter, val context: Context) : ISplashInteractor {

  override fun saveLogin(login: Login) {
    LoginDAO().insert(context, login)
    presenter.callNextActivity()
  }

  override fun downloadLogins() {

    var logins = LoginDAO().select(context)

    if (logins.size == 0) {
      Factory.create().login()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribeOn(Schedulers.io())
          .subscribe(
              { result ->
                saveLogin(result)
              }, { error ->
            presenter.callNextActivity()
          })
    } else {
      presenter.callNextActivity()
    }
  }
}