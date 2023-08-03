package com.example.core.common.route.common

import android.content.Intent


private const val PREFIX_ACTIVITY = "com.example"
//com.example.feature.deliveries
fun Any.intentForAction(action: String): Intent {
    //val intent = Intent(this, MarvelActivity::class.java)

    return Intent("com.example.nowinjetpack.feature.marvel.MarvelActivity")

}