package com.lib.licious

import android.app.Application
import com.lib.licious.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LiciousApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@LiciousApp)
            modules(appModule)
        }
    }
}