package com.example.redfinapp

import android.app.Application
import com.example.redfinapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RedfinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RedfinApplication)
            modules(appModule)
        }
    }
}
