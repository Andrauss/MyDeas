package com.luizzabuscka.mydeas

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.luizzabuscka.mydeas.utils.Prefs

/**
 * Created by luizzabuscka on 16/08/17.
 */
class MyDeasApplication : MultiDexApplication() {

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