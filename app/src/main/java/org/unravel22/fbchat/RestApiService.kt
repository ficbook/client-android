package org.unravel22.fbchat

import org.unravel22.fbchat.models.*
import retrofit2.Call
import retrofit2.http.*


/**
 * Created by admin on 01.09.17.
 */
interface RestApiService {

    @POST("users/sign_in")
    fun signIn(@Body credentials: Credentials): Call<Account>

    @GET("rooms")
    fun getRooms(): Call<ArrayList<RoomHeader>>

    @GET("rooms/<id>")
    fun getRoom(@Path("id") id: Int): Call<Room>

    @DELETE("rooms/<id>")
    fun deleteRoom(@Path("id") id: Int): Call<Unit>

    @POST("rooms/new")
    fun createRoom(@Body room: Room): Call<Room>

    @POST("rooms/<id>")
    fun updateRoom(@Path("id") id: Int, @Body room: Room): Call<Room>

    @GET("rooms/<id>/members")
    fun getRoomMembers(@Path("id") roomId: Int): Call<ArrayList<User>>
}