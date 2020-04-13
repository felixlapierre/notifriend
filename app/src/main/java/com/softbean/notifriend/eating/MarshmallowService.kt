package com.softbean.notifriend.eating

import android.content.Intent
import com.softbean.notifriend.NotifriendService
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class MarshmallowService : NotifriendService("MarshmallowService") {
    override fun doService(intent: Intent) {
        for(i in 0..14) {
            val id = R.drawable::class.java.getField("marsh$i").getInt(0)
            MarshmallowNotification(this, id).send(name)
            Utils.sleep(100)
        }
    }
}