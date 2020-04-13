package com.softbean.notifriend

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationDismissedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(context != null && intent != null) {
            val notificationId = intent.extras!!.getInt("com.softbean.notifriend.notificationId")
            if(notificationId == Notification.notificationId) {
                NotifriendService.currentService = "None"
            }
        }
    }
}