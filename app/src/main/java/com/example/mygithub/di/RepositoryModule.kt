package com.example.mygithub.di

import com.example.mygithub.data.repository.GithubRepositoryImpl
import com.example.mygithub.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: GithubRepositoryImpl): GithubRepository
}