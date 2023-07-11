package com.example.rent_of_things_app

import android.app.Application
import com.example.rent_of_things_app.di.providePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                //provideNetworkModule(),
                //provideDataModule(),
                //provideDomainModule(),
                providePresentationModule(),
                //provideDataBaseModule(),
            )
        }
    }
}