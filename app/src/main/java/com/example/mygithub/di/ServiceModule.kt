package com.example.mygithub.di

import com.example.mygithub.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {
    @Provides
    @Singleton
    fun provideCustomerService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}