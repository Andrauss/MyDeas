package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.login.LoginResult
import com.luizzabuscka.mydeas.R
import kotlinx.android.synthetic.main.activity_login.fbButton
import com.facebook.FacebookException
import org.jetbrains.anko.AnkoLogger


class LoginActivity : AppCompatActivity(), AnkoLogger {

  var callbackManager = CallbackManager.Factory.create()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    configureFB()
  }

  fun configureFB() {
    fbButton.setReadPermissions("email")
    fbButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
      override fun onSuccess(loginResult: LoginResult) {

      }

      override fun onCancel() {

      }

      override fun onError(e: FacebookException) {

      }
    })

  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    callbackManager.onActivityResult(requestCode, resultCode, data);
  }


}
