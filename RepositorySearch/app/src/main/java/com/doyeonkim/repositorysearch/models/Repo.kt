package com.doyeonkim.repositorysearch.models

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("full_name") val name: String,
    val language: String,
    val owner: Owner,
    @SerializedName("html_url") val url: String,
    val description: String,
    val forks: Int,
    val watchers: Int,
)
