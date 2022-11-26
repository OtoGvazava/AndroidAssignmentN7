package com.example.assignment7.api

import com.example.assignment7.model.User
import com.example.assignment7.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqresRequests {
    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<Users>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<User>
}