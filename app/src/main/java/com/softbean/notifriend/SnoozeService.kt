package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent
import android.graphics.BitmapFactory
import android.icu.util.TimeUnit
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class SnoozeService : IntentService("SnoozeService") {
    companion object {
        val TAG = "SnoozeService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG, "onHandleIntent()$intent")

        if (intent != null) {
            handleActionSnooze()
        }

    }

    private fun handleActionSnooze() {
        Log.d(TAG, "handleActionSnooze()")

        val notificationManagerCompat =
            NotificationManagerCompat.from(applicationContext)
        notificationManagerCompat.cancel(Notification.notificationId)
        try {
            Thread.sleep(2000)
        } catch (ex: InterruptedException) {
            Thread.currentThread().interrupt()
        }
        SnoozeNotification(this).send()
    }

}