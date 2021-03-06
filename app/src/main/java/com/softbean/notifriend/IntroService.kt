package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent

class IntroService: IntentService("IntroService") {
    override fun onHandleIntent(intent: Intent?) {

        if(intent != null) {
            NotifriendService.currentService = "IntroService"
            IntroNotification(this).send()
        }
    }
}
