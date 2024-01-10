package com.falter.banyar.base

import android.app.Application
import com.falter.banyar.di.messagingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Fardal on 1/10/2024.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                messagingModule
            )
        }
    }
}