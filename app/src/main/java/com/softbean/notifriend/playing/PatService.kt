package com.softbean.notifriend.playing

import android.content.Intent
import com.softbean.notifriend.*

class PatService : NotifriendService("PatService") {
    override fun doService(intent: Intent) {
        for(i in 0..9) {
            val id = R.drawable::class.java.getField("pats$i").getInt(0)
            PatNotification(this, id).send(name)
            Utils.sleep(100)
        }

        IntroNotification(this).send()
    }
}