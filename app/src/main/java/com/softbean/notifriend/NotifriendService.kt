package com.softbean.notifriend

import android.app.IntentService
import android.content.Intent

abstract class NotifriendService constructor(protected val name: String) : IntentService(name) {
    companion object {
        var currentService: String = "None"
    }
    override fun onHandleIntent(intent: Intent?) {
        if(intent != null) {
            currentService = name
            doService(intent)
        }
    }

    abstract fun doService(intent: Intent)

    fun amCurrentService(): Boolean {
        return currentService == name
    }
}