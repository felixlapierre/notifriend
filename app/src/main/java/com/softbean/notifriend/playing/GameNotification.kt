package com.softbean.notifriend.playing

import android.content.Context
import com.softbean.notifriend.IntroService
import com.softbean.notifriend.Notification
import com.softbean.notifriend.PendingService

abstract class GameNotification constructor(context: Context) : Notification(context) {
    init {
        addAction(PendingService(context, PlayingService::class.java, "Play something else!").asAction())
        addAction(PendingService(context, IntroService::class.java, "Done Playing").asAction())
    }

}