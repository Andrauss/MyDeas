package com.luizzabuscka.mydeas

import android.app.Application
import com.luizzabuscka.mydeas.utils.Prefs

/**
 * Created by luizzabuscka on 16/08/17.
 */
class MyDeasApplication : Application() {

  companion object {
    var prefs: Prefs? = null
  }

  override fun onCreate() {
    super.onCreate()
    prefs = Prefs(applicationContext)
  }

}

val prefs: Prefs by lazy {
  MyDeasApplication.prefs!!
}