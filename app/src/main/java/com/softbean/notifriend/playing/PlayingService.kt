package com.softbean.notifriend.playing

import android.content.Intent
import com.softbean.notifriend.NotifriendService
import com.softbean.notifriend.PendingService
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils
import java.util.*

class PlayingService : NotifriendService("PlayingService") {
    override fun doService(intent: Intent) {
        // Schedule the next playtime, avoiding nighttime playing
        val nextPlaytime = PendingService(this, PlayingService::class.java, "Play")
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        if(hour >= 23 || hour < 8) {
            nextPlaytime.delayUntilMorning()
        } else {
            nextPlaytime.delayRandomBetween(30, 180)
        }

        // Animate the current playtime
        while(amCurrentService()) {
            for(i in 0..8) {
                val id = R.drawable::class.java.getField("play$i").getInt(0)
                PlayingNotification(this, id).send(name)
                Utils.sleep(500)
            }
        }
    }
}