package com.example.mygithub.domain.repository

import com.example.mygithub.data.vo.Result
import com.example.mygithub.domain.entity.SearchGithubUser

interface GithubRepository {
    suspend fun searchGithubUser(query: String, page: Int, perPage: Int): Result<List<SearchGithubUser>>
}