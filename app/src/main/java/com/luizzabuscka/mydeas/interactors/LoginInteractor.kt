package com.luizzabuscka.mydeas.interactors

import android.content.Context
import com.luizzabuscka.mydeas.database.LoginDAO
import com.luizzabuscka.mydeas.model.Login
import com.luizzabuscka.mydeas.presentation.ILoginPresenter
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.SUCCESS
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.WRONG_USER_OR_PASS



/**
 * Created by luizzabuscka on 12/09/17.
 */
class LoginInteractor(var presenter: ILoginPresenter, val context: Context) : ILoginInteractor {

  override fun login(login: Login) {
    if (LoginDAO().selectLogin(login, context).isNotEmpty()) {
      presenter.loginResponse(SUCCESS)
    } else {
      presenter.loginResponse(WRONG_USER_OR_PASS)
    }



  }


}