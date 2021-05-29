package com.example.mygithub.data.repository

import com.example.mygithub.data.dispatcher.DispatcherProvider
import com.example.mygithub.data.mapper.SearchGithubUserMapper
import com.example.mygithub.data.source.GithubRemoteDataSource
import com.example.mygithub.data.vo.Result
import com.example.mygithub.domain.entity.SearchGithubUser
import com.example.mygithub.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val remoteDataSource: GithubRemoteDataSource,
    private val mapper: SearchGithubUserMapper
) : GithubRepository {
    override suspend fun searchGithubUser(query: String): Result<List<SearchGithubUser>> {
        return when (val apiResult = remoteDataSource.searchGithubUser(dispatcher.io, query)) {
            is Result.Success -> Result.Success(mapper.map(apiResult.data))
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
            else -> Result.Error()
        }
    }
}