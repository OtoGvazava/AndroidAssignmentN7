package com.example.assignment7.api

import com.example.assignment7.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReqresRequests {
    @GET("users?page={page}")
    fun getUsers(@Path("page") page: Int): Call<Users>

    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<Users>
}