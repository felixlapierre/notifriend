package com.softbean.notifriend

class Utils {
    companion object {
        fun sleep(millis: Long) {
            try {
                Thread.sleep(millis)
            } catch (ex: InterruptedException) {
                Thread.currentThread().interrupt()
            }
        }
    }
}