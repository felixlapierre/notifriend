package com.softbean.notifriend.playing

import android.content.Intent
import com.softbean.notifriend.NotifriendService
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class PlayingService : NotifriendService("PlayingService") {
    override fun doService(intent: Intent) {
        while(amCurrentService()) {
            for(i in 0..8) {
                val id = R.drawable::class.java.getField("play$i").getInt(0)
                PlayingNotification(this, id).send(name)
                Utils.sleep(500)
            }
        }
    }
}