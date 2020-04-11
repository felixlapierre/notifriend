package com.softbean.notifriend

import android.app.AlarmManager
import android.app.IntentService
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.core.app.NotificationManagerCompat

class FetchService : IntentService("FetchService") {
    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            val notificationManagerCompat =
                NotificationManagerCompat.from(applicationContext)
            notificationManagerCompat.cancel(Notification.notificationId)
            playFetch()
        }
    }

    private fun playFetch() {
        for(i in 0..16) {
            val id = R.drawable::class.java.getField("fetch$i").getInt(0)
            FetchNotification(this, id).send()
            sleep(100)
        }
        FetchNotification(this, R.drawable.fetchblank).send()
        sleep(2000)
        for(i in 0..15) {
            val id = R.drawable::class.java.getField("fetch2_$i").getInt(0)
            FetchNotification(this, id).send()
            sleep(100)
        }

        val introAction = PendingService(this, IntroService::class.java, "Intro")

        introAction.delay(10 * 1000)
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (ex: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}