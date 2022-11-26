package com.example.assignment7.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReqresApi {
    private const val baseUrl = "https://reqres.in/api/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val requests: ReqresRequests by lazy {
        getInstance().create(ReqresRequests::class.java)
    }
}