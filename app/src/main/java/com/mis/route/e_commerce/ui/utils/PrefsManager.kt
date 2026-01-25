package com.mis.route.e_commerce.ui.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import java.util.concurrent.TimeUnit


object PrefsManager {

    private const val PREF_NAME = "secure_prefs"
    private const val KEY_TOKEN = "user_token"
    private const val KEY_LOGIN_TIME = "login_time"

    private fun getPrefs(context: Context) =
        EncryptedSharedPreferences.create(
            context,
            PREF_NAME,
            MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    fun saveLogin(context: Context, token: String) {
        getPrefs(context).edit()
            .putString(KEY_TOKEN, token)
            .putLong(KEY_LOGIN_TIME, System.currentTimeMillis())
            .apply()
    }

    fun getToken(context: Context): String? =
        getPrefs(context).getString(KEY_TOKEN, null)

    fun isLoginValid(context: Context): Boolean {
        val lastLoginTime = getPrefs(context).getLong(KEY_LOGIN_TIME, 0L)
        if (lastLoginTime == 0L) return false

        val daysPassed = TimeUnit.MILLISECONDS.toDays(
            System.currentTimeMillis() - lastLoginTime
        )

        return daysPassed < 30
    }

    fun clear(context: Context) {
        getPrefs(context).edit().clear().apply()
    }
}
