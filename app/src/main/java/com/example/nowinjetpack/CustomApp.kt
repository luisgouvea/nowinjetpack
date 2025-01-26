package com.example.nowinjetpack

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.nowinjetpack.core.common.ModuleInitializer
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
open class CustomApp :
    Application(),
    LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        //setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            modules(
                ModuleInitializer.modules
            )
            androidContext(this@CustomApp)
        }
    }
}