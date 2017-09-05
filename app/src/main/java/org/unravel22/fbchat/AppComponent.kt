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
@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface AppComponent {

    fun getRestService(): RestApiService
}

@Module
class RetrofitModule {

    @Provides
    @Singleton
    internal fun provideRestService(): RestApiService {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.0.105:7070")
                .build()
                .create(RestApiService::class.java)
    }
}