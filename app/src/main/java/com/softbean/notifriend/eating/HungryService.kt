package com.softbean.notifriend.eating

import android.app.IntentService
import android.content.Intent
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils

class HungryService : IntentService("HungryService") {
    override fun onHandleIntent(intent: Intent?) {
        if (intent != null) {
            displayHungry()
        }
    }

    private fun displayHungry() {
        for (i in 0..4) {
            val id = R.drawable::class.java.getField("noms$i").getInt(0)
            HungryNotification(this, id).send()
            Utils.sleep(100)
        }
    }
}