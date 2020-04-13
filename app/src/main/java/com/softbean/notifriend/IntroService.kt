package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent
import com.softbean.notifriend.eating.HungryNotification
import com.softbean.notifriend.eating.HungryService

class IntroService: IntentService("IntroService") {
    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            IntroNotification(this).send()

            PendingService(this, HungryService::class.java, "Hungry").delay(10 * 1000)
        }
    }
}