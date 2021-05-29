package com.example.mygithub.data.mapper

import com.example.mygithub.abstraction.Mapper
import com.example.mygithub.data.response.SearchGithubUserDto
import com.example.mygithub.domain.entity.SearchGithubUser
import javax.inject.Inject

class SearchGithubUserMapper @Inject constructor(): Mapper<SearchGithubUserDto, List<SearchGithubUser>>() {
    override fun map(input: SearchGithubUserDto): List<SearchGithubUser> {
        return input.items?.map {
            SearchGithubUser(
                it.id ?: 0,
                it.login ?: "",
                it.avatarUrl ?: ""
            )
        } ?: emptyList()
    }
}