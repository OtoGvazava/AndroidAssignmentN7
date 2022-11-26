package com.example.assignment7.model

import com.google.gson.annotations.SerializedName

data class Users(
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    val data: List<UserData>
)
