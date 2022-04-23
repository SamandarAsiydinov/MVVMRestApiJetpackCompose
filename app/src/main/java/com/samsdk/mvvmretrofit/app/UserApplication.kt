package com.samsdk.mvvmretrofit.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UserApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}