package com.softbean.notifriend

import android.app.IntentService
import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.util.*
import kotlin.concurrent.schedule

class PatService() : IntentService("PatService") {

    companion object {
        val TAG = "PatService"
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, " onHandleIntent()$intent")

        if (intent!= null){
            handleActionPat()
        }
    }

    private fun handleActionPat() {
        Log.d(TAG, "handlePat()")

        PatNotification(this).send()

        val context = this
        Timer("Patting", false).schedule(2500) {
            IntroNotification(context).send()
        }
    }
}