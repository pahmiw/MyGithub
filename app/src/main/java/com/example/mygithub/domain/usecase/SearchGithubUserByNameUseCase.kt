package com.example.mygithub.domain.usecase

import com.example.mygithub.abstraction.UseCase
import com.example.mygithub.data.vo.Result
import com.example.mygithub.domain.entity.SearchGithubUser
import com.example.mygithub.domain.entity.SearchGithubUserParams
import com.example.mygithub.domain.repository.GithubRepository
import javax.inject.Inject

class SearchGithubUserByNameUseCase @Inject constructor(private val repository: GithubRepository) :
    UseCase<SearchGithubUserParams, Result<List<SearchGithubUser>>>() {
    override suspend fun invoke(params: SearchGithubUserParams): Result<List<SearchGithubUser>> {
        return repository.searchGithubUser(params.username, params.page, params.perPage)
    }
}