package com.example.mygithub.data.response

import com.squareup.moshi.Json

data class SearchGithubUserDto(
    @field:Json(name = "items")
    val items: List<Item>?
) {
    data class Item(
        @field:Json(name = "avatar_url")
        val avatarUrl: String?,
        @field:Json(name = "id")
        val id: Int?,
        @field:Json(name = "login")
        val login: String?
    )
}