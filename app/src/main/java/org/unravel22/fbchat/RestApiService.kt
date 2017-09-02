package org.unravel22.fbchat

import org.unravel22.fbchat.models.Account
import org.unravel22.fbchat.models.Credentials
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST



/**
 * Created by admin on 01.09.17.
 */
interface RestApiService {

    @POST("users/sign_in")
    fun signIn(@Body credentials: Credentials): Call<Account>
}