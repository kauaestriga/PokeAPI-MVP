package com.example.pokeapi_mvp

import android.app.Application
import com.facebook.stetho.BuildConfig
import com.facebook.stetho.Stetho

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }
}