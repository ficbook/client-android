package org.unravel22.fbchat

import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by admin on 05.09.17.
 */

@Component(modules = arrayOf(RetrofitModule::class))
interface AppComponent {

    fun getRestService(): RestApiService
}

@Module
class RetrofitModule {

    private val builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    internal fun provideRestService(): RestApiService {
        return builder.baseUrl("http://192.168.0.105:7070")
                .build()
                .create(RestApiService::class.java)
    }
}