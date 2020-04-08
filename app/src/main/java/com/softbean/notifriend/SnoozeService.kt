package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent
import android.graphics.BitmapFactory
import android.icu.util.TimeUnit
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*
import kotlin.concurrent.schedule


class SnoozeService : IntentService("SnoozeService") {

    class SnoozeServiceProperties{
        public val TAG = "SnoozeService"
    }

    private val channelId = "NOTIFRIEND_CHANNEL_ID"
    private val notificationId = 176
    private val properties = SnoozeServiceProperties();


    override fun onHandleIntent(intent: Intent?) {
        Log.i(properties.TAG, "onHandleIntent()$intent")

        if (intent != null)
        {
                handleActionSnooze()
        }

    }

    private fun handleActionSnooze() {
        Log.d(properties.TAG, "handleActionSnooze()")


        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_small_nubb)
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(BitmapFactory.decodeResource(resources, R.drawable.samplenubb))
                .bigLargeIcon(null)
                .setBigContentTitle("Hi!")
                .setSummaryText("I had a nice nap!")
            )
            .setContentTitle("Your lad just woke up!")
            .setContentText("He misses you!")
            .setSubText("Nubb's space")
            .setLargeIcon((BitmapFactory.decodeResource(resources, R.drawable.smolnubb)))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(6405212)

        val notification = builder.build()

        if (notification != null) {
            val notificationManagerCompat =
                NotificationManagerCompat.from(applicationContext)
            notificationManagerCompat.cancel(notificationId)

            Timer("Patting", false).schedule(2500) {
                notificationManagerCompat.notify(notificationId, notification)
            }


        }

    }

}