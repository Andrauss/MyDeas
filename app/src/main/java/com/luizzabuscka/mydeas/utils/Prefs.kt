package com.luizzabuscka.mydeas.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by luizzabuscka on 13/09/17.
 */
class Prefs(context: Context) {

  val PREFS_FILENAME = "com.luizzabuscka.mydeas.prefs"
  val LOGGED = "logged"
  val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

  var logged: Boolean
    get() = prefs.getBoolean(LOGGED, false)
    set(value) = prefs.edit().putBoolean(LOGGED, value).apply()
}