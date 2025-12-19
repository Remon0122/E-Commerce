package com.mis.route.e_commerce.ui.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object PrefsHelper {

    private const val PREFS_FILE = "user_prefs"
    private const val KEY_TOKEN = "token"
    private const val KEY_LAST_LOGIN = "lastLoginTime"

    // إنشاء SharedPreferences مشفرة
    private fun getPrefs(context: Context) = EncryptedSharedPreferences.create(
        context,
        PREFS_FILE,
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    // حفظ Token ووقت آخر Login
    fun saveLogin(context: Context, token: String) {
        val prefs = getPrefs(context)
        with(prefs.edit()) {
            putString(KEY_TOKEN, token)
            putLong(KEY_LAST_LOGIN, System.currentTimeMillis())
            apply()
        }
    }

    // قراءة Token
    fun getToken(context: Context): String? {
        return getPrefs(context).getString(KEY_TOKEN, null)
    }

    // red The Last Login
    fun getLastLoginTime(context: Context): Long {
        return getPrefs(context).getLong(KEY_LAST_LOGIN, 0L)
    }

    // Delete The Last Logout
    fun clearLogin(context: Context) {
        val prefs = getPrefs(context)
        with(prefs.edit()) {
            clear()
            apply()
        }
    }

    // التحقق إذا المستخدم يقدر يتخطى Login خلال 30 يوم
    fun shouldSkipLogin(context: Context): Boolean {
        val token = getToken(context)
        val lastLogin = getLastLoginTime(context)
        val currentTime = System.currentTimeMillis()
        val THIRTY_DAYS = 30L * 24 * 60 * 60 * 1000

        return token != null && (currentTime - lastLogin <= THIRTY_DAYS)
    }
}