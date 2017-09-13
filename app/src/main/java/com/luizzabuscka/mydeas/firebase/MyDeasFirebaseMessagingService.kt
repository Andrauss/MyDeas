package com.luizzabuscka.mydeas.firebase

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder
import br.com.goncalves.pugnotification.notification.PugNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.luizzabuscka.mydeas.R

/**
 * Created by luizzabuscka on 13/09/17.
 */
class MyDeasFirebaseMessagingService : FirebaseMessagingService() {

  override fun onMessageReceived(message: RemoteMessage?) {

    PugNotification.with(this)
        .load()
        .title(message?.notification?.title)
        .message(message?.notification?.body!!)
        .bigTextStyle(message?.notification?.body!!)
        .smallIcon(R.drawable.ic_stat_name)
        .largeIcon(R.drawable.thinking)
        .color(R.color.colorAccent)
        .flags(Notification.DEFAULT_ALL)
        .autoCancel(true)
        .simple()
        .build()

  }

}