package com.example.mygithub.di

import com.example.mygithub.data.dispatcher.CoroutineDispatcherProvider
import com.example.mygithub.data.dispatcher.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}