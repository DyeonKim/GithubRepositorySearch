package com.doyeonkim.repositorysearch

import com.doyeonkim.repositorysearch.models.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/repositories")
    fun loadRepo(
        @Query("q") q: String,
        @Query("sort") sort: String = "stars"
    ): Call<Repo>
}