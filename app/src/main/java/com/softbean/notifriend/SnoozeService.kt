package com.softbean.notifriend

import android.content.Intent

class SnoozeService : NotifriendService("SnoozeService") {
    override fun doService(intent: Intent) {
        while(amCurrentService()) {
            for (i in 0..3) {
                val id = R.drawable::class.java.getField("snooze$i").getInt(0)
                SnoozeNotification(this, id).send(name)
                Utils.sleep(1000)
            }
            for (i in 0..3) {
                val id = R.drawable::class.java.getField("snooze$i").getInt(0)
                SnoozeNotification(this, id).send(name)
                Utils.sleep(1000)
            }
        }
    }
}