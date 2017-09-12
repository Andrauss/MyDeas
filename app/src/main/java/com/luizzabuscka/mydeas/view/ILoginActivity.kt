package com.luizzabuscka.mydeas.view

import android.content.Intent
import com.luizzabuscka.mydeas.utils.enum.LoginEnum

/**
 * Created by luizzabuscka on 12/09/17.
 */
interface ILoginActivity {
  fun showError(type: LoginEnum)
  fun callNextActivity(intent: Intent)
}