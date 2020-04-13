package com.softbean.notifriend.playing

import android.content.Intent
import com.softbean.notifriend.NotifriendService

class PatService : NotifriendService("PatService") {
    override fun doService(intent: Intent) {
        PatNotification(this).send(name)
    }
}