package com.example.rent_of_things_app.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

fun provideSharedPreferencesModule(): Module =
    module {
        single<SharedPreferences> {
            getSharedPrefs(androidApplication())
        }
    }

fun getSharedPrefs(androidApplication: Application): SharedPreferences{
    return  androidApplication.getSharedPreferences("user_shared_preferences",  MODE_PRIVATE)
}