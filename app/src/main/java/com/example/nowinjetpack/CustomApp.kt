package com.example.nowinjetpack

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.example.core.common.ModuleInitializer
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class CustomApp :
    Application(),
    LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
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