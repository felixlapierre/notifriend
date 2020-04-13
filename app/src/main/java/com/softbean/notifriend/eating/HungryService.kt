package com.softbean.notifriend.eating

import android.content.Intent
import com.softbean.notifriend.NotifriendService
import com.softbean.notifriend.R
import com.softbean.notifriend.Utils


class HungryService : NotifriendService("HungryService") {
    override fun doService(intent: Intent) {
        for (i in listOf(0, 1, 0, 1, 0)) {
            HungryNotification(this, getFrame(i)).send(name)
            Utils.sleep(250)
        }
        Utils.sleep(100)
        HungryNotification(this, getFrame(2)).send(name)

        Utils.sleep(500)

        while (amCurrentService()) {
            for (i in listOf(3, 4, 3, 4, 3, 4)) {
                val id = getFrame(i)
                HungryNotification(this, id).send(name)
                Utils.sleep(250)
            }
        }
    }

    private fun getFrame(i: Int): Int {
        return R.drawable::class.java.getField("noms$i").getInt(0)
    }
}