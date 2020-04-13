package com.softbean.notifriend.eating

import android.content.Intent
import com.softbean.notifriend.NotifriendService
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class OnigiriService : NotifriendService("OnigiriService") {
    override fun doService(intent: Intent) {
        for(i in 0..10) {
            val id = R.drawable::class.java.getField("onigiri$i").getInt(0)
            OnigiriNotification(this, id).send(name)
            Utils.sleep(100)
        }
    }
}