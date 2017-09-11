package com.luizzabuscka.mydeas.interactors

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.luizzabuscka.mydeas.database.LoginDAO
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.presentation.ISplashPresenter
import com.luizzabuscka.mydeas.services.Factory
import com.luizzabuscka.mydeas.utils.database
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.db.RowParser
import org.jetbrains.anko.db.SqlOrderDirection
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.rowParser
import org.jetbrains.anko.db.select

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
          .subscribe({ result ->
            saveLogin(result)
          }, { error ->
            presenter.callNextActivity()
          })
    } else {
      presenter.callNextActivity()
    }
  }
}