package com.luizzabuscka.mydeas.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.login.LoginResult
import com.luizzabuscka.mydeas.R
import kotlinx.android.synthetic.main.activity_login.fbButton
import com.facebook.FacebookException
import com.luizzabuscka.mydeas.R.string
import com.luizzabuscka.mydeas.presentation.LoginPresenter
import com.luizzabuscka.mydeas.utils.enum.LoginEnum
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.EMPTY_PASSWORD
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.EMPTY_USER
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.FACEBOOK_ERROR
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.SUCCESS
import com.luizzabuscka.mydeas.utils.enum.LoginEnum.WRONG_USER_OR_PASS
import com.luizzabuscka.mydeas.utils.putDropShadow
import kotlinx.android.synthetic.main.activity_login.btEnter
import kotlinx.android.synthetic.main.activity_login.etPassword
import kotlinx.android.synthetic.main.activity_login.etUser
import kotlinx.android.synthetic.main.activity_login.input_layout_password
import kotlinx.android.synthetic.main.activity_login.input_layout_user
import kotlinx.android.synthetic.main.activity_login.ivLogo
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import android.opengl.ETC1.getHeight
import android.view.ViewTreeObserver




class LoginActivity : AppCompatActivity(), ILoginActivity, AnkoLogger {

  val presenter = LoginPresenter(this, this)

  val callbackManager = CallbackManager.Factory.create()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    configureFB()

    btEnter.setOnClickListener {
      tryLogin()
    }

    etPassword.setOnEditorActionListener(object: OnEditorActionListener {
      override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        tryLogin()
        return true
      }
    })

    ivLogo.putDropShadow()

  }

  fun tryLogin() {
    input_layout_user.error = null
    input_layout_password.error = null
    presenter.login(etUser.text.toString(), etPassword.text.toString())
  }

  fun configureFB() {
    fbButton.setReadPermissions("email")
    fbButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
      override fun onSuccess(loginResult: LoginResult) {
        presenter.loginResponse(SUCCESS)
      }

      override fun onCancel() {
        //Nothing to do
      }

      override fun onError(e: FacebookException) {
        showError(FACEBOOK_ERROR)
      }
    })
  }

  override fun showError(type: LoginEnum) {
    val errorMessage = when (type) {
      EMPTY_USER -> getString(string.error_empty_user)
      EMPTY_PASSWORD -> getString(string.error_empty_password)
      WRONG_USER_OR_PASS -> getString(string.error_wrong_user_or_pass)
      FACEBOOK_ERROR -> getString(string.error_facebook_login)
      else -> getString(string.error_unknown)
    }

    when (type) {
      EMPTY_USER -> input_layout_user.error = errorMessage
      EMPTY_PASSWORD -> input_layout_password.error = errorMessage
      WRONG_USER_OR_PASS -> input_layout_user.error = errorMessage
      FACEBOOK_ERROR -> toast(errorMessage)
      else -> toast(errorMessage)
    }

  }

  override fun callNextActivity(intent: Intent) {
    startActivity(intent)
    finish()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    callbackManager.onActivityResult(requestCode, resultCode, data);
  }


}
