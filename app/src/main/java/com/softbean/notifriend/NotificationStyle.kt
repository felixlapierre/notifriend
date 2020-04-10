package com.softbean.notifriend

import androidx.core.app.NotificationCompat

interface NotificationStyle {
    fun getStyle(): NotificationCompat.Style
}