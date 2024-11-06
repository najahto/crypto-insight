package com.najahto.cryptoinsight

import android.app.Application
import com.najahto.cryptoinsight.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CryptoInsightApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoInsightApp)
            androidLogger()

            modules(appModule)
        }
    }
}