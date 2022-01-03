package com.doyeonkim.repositorysearch

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    val SERVER_URL = "https://api.github.com/"

    companion object {
        lateinit var retrofit: Retrofit
        lateinit var service: GitHubApi
    }

    override fun onCreate() {
        super.onCreate()
        retrofit = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(GitHubApi::class.java)
    }
}