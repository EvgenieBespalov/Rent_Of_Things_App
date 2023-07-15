package com.example.rent_of_things_app.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module


fun provideSharedPreferencesModule(): Module =
    module {
        single {
            SharedPreferencesManager(androidApplication())
        }
    }

class SharedPreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences("user_shared_preferences", MODE_PRIVATE)
    }

    val userId: String?
        get() = sharedPreferences.getString("USERID", null)

    fun clearUserId() {
        sharedPreferences.edit().clear().apply()
    }

    fun saveUserId(userId: String) {
        sharedPreferences.edit().putString("USERID", userId).apply()
    }

    val cookie: String?
        get() = sharedPreferences.getString("COOKIE", null)

    fun clearCookie() {
        sharedPreferences.edit().clear().apply()
    }

    fun saveCookie(cookie: String) {
        sharedPreferences.edit().putString("COOKIE", cookie).apply()
    }
}