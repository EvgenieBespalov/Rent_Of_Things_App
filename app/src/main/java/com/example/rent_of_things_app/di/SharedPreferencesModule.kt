package com.example.rent_of_things_app.di

import android.app.Application
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
        get() = sharedPreferences.getString("PHONE", null)

    fun clearUserId() {
        sharedPreferences.edit().clear().apply()
    }

    fun saveUserId(phone: String) {
        sharedPreferences.edit().putString("PHONE", phone).apply()
    }
}