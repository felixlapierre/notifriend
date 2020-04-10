package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent
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
            try {
                Thread.sleep(50)
            } catch (ex: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
        FetchNotification(this, R.drawable.fetchblank).send()
    }
}