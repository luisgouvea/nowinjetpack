package com.example.nowinjetpack

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class CustomApp :
    Application(),
    LifecycleObserver {


}