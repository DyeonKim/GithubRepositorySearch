package com.doyeonkim.repositorysearch.models

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login") val userId: String,
    val avatarUrl: String
)
