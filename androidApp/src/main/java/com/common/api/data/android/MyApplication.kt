package com.common.api.data.android

import android.app.Application
import com.common.api.data.android.data.appModule
import com.common.api.data.data.model.init
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

}