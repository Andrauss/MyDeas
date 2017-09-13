package com.luizzabuscka.mydeas.utils

import android.graphics.Bitmap
import android.graphics.Bitmap.Config
import android.graphics.BlurMaskFilter.Blur
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.PorterDuffXfermode
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Matrix.ScaleToFit
import android.graphics.Paint
import android.graphics.PorterDuff.Mode
import android.graphics.RectF
import android.graphics.drawable.BitmapDrawable
import android.view.ViewTreeObserver
import android.widget.ImageView
import com.luizzabuscka.mydeas.R
import kotlinx.android.synthetic.main.activity_login.ivLogo
import org.jetbrains.anko.imageBitmap


/**
 * Created by luizzabuscka on 12/09/17.
 */
class ImageUtil {

  fun imgshadow(bm: Bitmap, dstHeight: Int, dstWidth: Int, color: Int, size: Int, dx: Float,
      dy: Float): Bitmap {
    val mask = Bitmap.createBitmap(dstWidth, dstHeight, Config.ALPHA_8)

    val scaleToFit = Matrix()
    val src = RectF(0f, 0f, bm.width.toFloat(), bm.height.toFloat())
    val dst = RectF(0f, 0f, dstWidth - dx, dstHeight - dy)
    scaleToFit.setRectToRect(src, dst, ScaleToFit.CENTER)

    val dropShadow = Matrix(scaleToFit)
    dropShadow.postTranslate(dx, dy)

    val maskCanvas = Canvas(mask)
    val paint = Paint(ANTI_ALIAS_FLAG)
    maskCanvas.drawBitmap(bm, scaleToFit, paint)
    paint.setXfermode(PorterDuffXfermode(Mode.SRC_OUT))
    maskCanvas.drawBitmap(bm, dropShadow, paint)

    val filter = BlurMaskFilter(size.toFloat(), Blur.NORMAL)
    paint.reset()
    paint.setAntiAlias(true)
    paint.setColor(color)
    paint.setMaskFilter(filter)
    paint.setFilterBitmap(true)

    val ret = Bitmap.createBitmap(dstWidth, dstHeight, Config.ARGB_8888)
    val retCanvas = Canvas(ret)
    retCanvas.drawBitmap(mask, 0f, 0f, paint)
    retCanvas.drawBitmap(bm, scaleToFit, null)
    mask.recycle()
    return ret
  }

}

fun ImageView.putDropShadow() {
  val iv = this
  this.getViewTreeObserver().addOnGlobalLayoutListener(
      object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
          iv.getViewTreeObserver().removeOnGlobalLayoutListener(this)
          iv.imageBitmap = ImageUtil().imgshadow((iv.drawable as BitmapDrawable).bitmap, iv.height, iv.width,
              iv.context.resources.getColor(R.color.shadow), 1, 5f, 5f)
        }
      })
}