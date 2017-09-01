package org.unravel22.fbchat

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by admin on 01.09.17.
 */
class ChatApplication: Application() {

    val restService: RestApiService by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://TODO/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        retrofit.create(RestApiService::class.java)
    }
}