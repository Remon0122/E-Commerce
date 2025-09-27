package com.example.e_commerce.ui.uitls

import android.content.Context
import androidx.core.content.edit

object PrefsManager {
    private const val PREFS_NAME = "user_prefs"
    private const val KEY_LAST_LOGIN = "last_login_time"


    fun saveLoginTime(context: Context){
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit {
            putLong(KEY_LAST_LOGIN, System.currentTimeMillis())
        }
    }
    fun getLastLoginTime(context: Context): Long {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getLong(KEY_LAST_LOGIN, 0L)
    }
    fun shouldSkipLogin(context: Context): Boolean {
        val lastLogin = PrefsManager.getLastLoginTime(context)
        if (lastLogin == 0L) return false

        val thirtyDaysMillis = 30L * 24 * 60 * 60 * 1000
        val now = System.currentTimeMillis()

        return (now - lastLogin) <= thirtyDaysMillis
    }
}