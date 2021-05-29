package com.example.mygithub.data.source

import com.example.mygithub.data.response.SearchGithubUserDto
import com.example.mygithub.data.service.ApiService
import com.example.mygithub.data.vo.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(private val service: ApiService) :
    RemoteDataSource() {

    suspend fun searchGithubUser(
        dispatcher: CoroutineDispatcher,
        query: String,
        page: Int,
        perPage: Int
    ): Result<SearchGithubUserDto> {
        return safeApiCall(dispatcher) { service.searchGithubUser(query, page, perPage) }
    }
}