package com.doyeonkim.repositorysearch

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.doyeonkim.repositorysearch.ApplicationClass.Companion.service
import com.doyeonkim.repositorysearch.models.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubService {
    fun loadRepo(q: String): LiveData<Repo> {
        val responseLiveData: MutableLiveData<Repo> = MutableLiveData()
        val call = service.loadRepo(q)

        call.enqueue(object : Callback<Repo> {
            override fun onResponse(call: Call<Repo>, response: Response<Repo>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        responseLiveData.value = response.body()
                        Log.d("GitHubService", "${responseLiveData.value}")
                    }
                } else {
                    Log.d("GitHubService", "onResponse: Error Code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Repo>, t: Throwable) {
                Log.d("GitHubService", t.message ?: "통신오류")
            }
        })

        return responseLiveData
    }
}