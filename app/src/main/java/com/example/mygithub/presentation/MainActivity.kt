package com.example.mygithub.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mygithub.R
import com.example.mygithub.abstraction.BaseActivity
import com.example.mygithub.data.vo.Result
import com.example.mygithub.databinding.ActivityMainBinding
import com.example.mygithub.domain.entity.SearchGithubUser
import com.example.mygithub.utils.EndlessRecyclerOnScrollListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, GithubUserViewModel>() {
    override fun getLayoutResourceId(): Int = R.layout.activity_main
    override fun getViewModelClass(): Class<GithubUserViewModel> = GithubUserViewModel::class.java
    private val adapter by lazy { GithubUserAdapter(emptyList()) }
    private var page = 1
    private var perPage = 10
    private var githubUsers = mutableListOf<SearchGithubUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecycleView()
        observeSearchGithubUser()
        vm.searchGithubUserByName("fahmi", page, perPage)
    }


    private fun observeSearchGithubUser() {
        vm.githubUser.observe(this, Observer {
            when (it) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    lifecycleScope.launch {
                        delay(1000)
                        binding.progressBar.visibility = View.GONE
                        githubUsers.addAll(it.data)
                        adapter.refreshData(githubUsers)
                    }
                }
                is Result.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "terdapat kesalahan pada aplikasi, mohon tunggu sebentar", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecycleView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvGithubUsers.layoutManager = layoutManager
        binding.rvGithubUsers.adapter = adapter

        binding.rvGithubUsers.addOnScrollListener(object : EndlessRecyclerOnScrollListener(layoutManager) {
            override fun onLoadMore(current_page: Int) {
                vm.searchGithubUserByName("fahmi", current_page, perPage)
            }

        })
    }
}