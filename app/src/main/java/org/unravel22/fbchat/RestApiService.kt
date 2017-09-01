package org.unravel22.fbchat

import android.accounts.Account
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST



/**
 * Created by admin on 01.09.17.
 */
interface RestApiService {

    @POST("users/sign_in")
    fun signIn(@Field("login") login: String, @Field("password") password: String): Call<Account>
}