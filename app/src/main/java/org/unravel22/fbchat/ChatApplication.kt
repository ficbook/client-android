package org.unravel22.fbchat

import android.app.Application




/**
 * Created by admin on 01.09.17.
 */
class ChatApplication: Application() {

    companion object {

        @JvmStatic lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        graph = DaggerAppComponent.builder()
                .retrofitModule(RetrofitModule())
                .build()
    }
}