package com.softbean.notifriend.eating

import android.app.IntentService
import android.content.Intent
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class MarshmallowService : IntentService("MarshmallowService") {
    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            eatMarshmallow()
        }
    }

    private fun eatMarshmallow() {
        for(i in 0..14) {
            val id = R.drawable::class.java.getField("marsh$i").getInt(0)
            MarshmallowNotification(this, id).send()
            Utils.sleep(100)
        }
    }
}