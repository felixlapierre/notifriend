package com.softbean.notifriend.playing

import android.content.Intent
import com.softbean.notifriend.*

class FetchService : NotifriendService("FetchService") {
    override fun doService(intent: Intent) {
        for(i in 0..16) {
            val id = R.drawable::class.java.getField("fetch$i").getInt(0)
            FetchNotification(this, id).send(name)
            Utils.sleep(100)
        }
        FetchNotification(
            this,
            R.drawable.fetchblank
        ).send(name)
        Utils.sleep(2000)
        for(i in 0..15) {
            val id = R.drawable::class.java.getField("fetch2_$i").getInt(0)
            FetchNotification(this, id).send(name)
            Utils.sleep(100)
        }
    }
}