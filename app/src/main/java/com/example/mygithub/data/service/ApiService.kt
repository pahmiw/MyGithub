package com.example.mygithub.data.service

import com.example.mygithub.data.response.SearchGithubUserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    suspend fun searchGithubUser(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): SearchGithubUserDto
}