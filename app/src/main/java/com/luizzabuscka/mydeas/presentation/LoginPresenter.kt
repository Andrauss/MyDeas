package com.luizzabuscka.mydeas.presentation

import android.content.Context
import android.content.Intent
import com.luizzabuscka.mydeas.interactors.LoginInteractor
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.presentation.interfaces.ILoginPresenter
import com.luizzabuscka.mydeas.utils.enum.LoginEnum
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.EMPTY_PASSWORD
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.EMPTY_USER
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.SUCCESS
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.WRONG_USER_OR_PASS
import com.luizzabuscka.mydeas.view.interfaces.ILoginActivity
import com.luizzabuscka.mydeas.view.MainActivity

/**
 * Created by luizzabuscka on 12/09/17.
 */
class LoginPresenter(val activity: ILoginActivity, val context: Context) : ILoginPresenter {

  val interactor = LoginInteractor(this, context)

  override fun login(user: String, password: String) {
    if (user.isNullOrEmpty()) {
      activity.showError(EMPTY_USER)
      return
    }

    if (password.isNullOrEmpty()) {
      activity.showError(EMPTY_PASSWORD)
      return
    }

    interactor.login(Login(user, password))

  }

  override fun loginResponse(type: LoginEnum) {
    if (type == SUCCESS) {
      activity.callNextActivity(Intent(context, MainActivity::class.java))
    } else if (type == WRONG_USER_OR_PASS) {
      activity.showError(WRONG_USER_OR_PASS)
    }
  }
}