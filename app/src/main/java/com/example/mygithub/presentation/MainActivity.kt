package com.example.mygithub.presentation

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mygithub.R
import com.example.mygithub.abstraction.BaseActivity
import com.example.mygithub.data.vo.Result
import com.example.mygithub.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, GithubUserViewModel>() {
    override fun getLayoutResourceId(): Int = R.layout.activity_main
    override fun getViewModelClass(): Class<GithubUserViewModel> = GithubUserViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeSearchGithubUser()
        vm.searchGithubUserByName("ahmadfahmiaisar")
    }

    private fun observeSearchGithubUser() {
        vm.githubUser.observe(this, Observer {
            when(it) {
                is Result.Loading -> {

                }
                is Result.Success -> {
                    Log.d("TAG", "observeSearchGithubUser: $it")
                }
                is Result.Error -> {

                }
            }
        })
    }
}