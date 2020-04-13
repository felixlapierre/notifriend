package com.softbean.notifriend.eating

import android.app.IntentService
import android.content.Intent
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class OnigiriService : IntentService("OnigiriService") {
    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            eatOnigiri()
        }
    }

    private fun eatOnigiri() {
        for(i in 0..10) {
            val id = R.drawable::class.java.getField("onigiri$i").getInt(0)
            OnigiriNotification(this, id).send()
            Utils.sleep(100)
        }
    }
}