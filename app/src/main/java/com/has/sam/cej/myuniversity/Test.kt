package com.has.sam.cej.myuniversity

import android.app.Application
import com.firebase.client.Firebase

class Test : Application(){

    override fun onCreate() {
        super.onCreate()
        Firebase.setAndroidContext(this)
    }
}