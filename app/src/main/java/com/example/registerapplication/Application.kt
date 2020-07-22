package com.example.registerapplication

import android.app.Application
import com.example.registerapplication.utils.SharedPrefsFactory

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPrefsFactory.getInstance().initConfig(this)
    }
}