package com.softbean.notifriend.playing

import android.app.IntentService
import android.content.Intent
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class PlayingService : IntentService("PlayingService") {
    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            play()
        }
    }

    private fun play() {
        for(i in 0..8) {
            val id = R.drawable::class.java.getField("play$i").getInt(0)
            PlayingNotification(this, id).send()
            Utils.sleep(100)
        }
    }
}