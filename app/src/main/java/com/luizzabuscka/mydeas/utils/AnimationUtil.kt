package com.luizzabuscka.mydeas.utils

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator

/**
 * Created by luizzabuscka on 12/09/17.
 */

fun View.fadeIn(duration: Long) {
  val fadeIn = AlphaAnimation(0f, 1f)
  fadeIn.interpolator = DecelerateInterpolator() //add this
  fadeIn.duration = duration

  val animation = AnimationSet(false) //change to false
  animation.addAnimation(fadeIn)
  this.startAnimation(animation)
}

fun View.fadeOut(duration: Long) {

  val fadeOut = AlphaAnimation(1f, 0f)
  fadeOut.interpolator = AccelerateInterpolator() //and this
  fadeOut.startOffset = 1000
  fadeOut.duration = duration

  val animation = AnimationSet(false) //change to false
  animation.addAnimation(fadeOut)
  this.startAnimation(animation)
}


