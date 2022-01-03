package com.doyeonkim.repositorysearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doyeonkim.repositorysearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var repoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repoAdapter = RepoAdapter(this)
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = repoAdapter
        }

        binding.btnSearch.setOnClickListener {
            val q = binding.etSearch.text.toString()

            if (q == "") {
                Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val repoListLiveData = GitHubService().loadRepo(q)
            repoListLiveData.observe(this, {
                repoAdapter.items = it.items
                repoAdapter.notifyDataSetChanged()
            })

        }
    }
}