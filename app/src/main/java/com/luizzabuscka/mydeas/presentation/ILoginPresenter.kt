package com.luizzabuscka.mydeas.presentation

import com.luizzabuscka.mydeas.utils.enum.LoginEnum

/**
 * Created by luizzabuscka on 12/09/17.
 */
interface ILoginPresenter {
  fun login(user: String, password: String)
  fun loginResponse(type: LoginEnum)
}