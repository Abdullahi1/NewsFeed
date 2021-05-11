package com.example.newsfeed.di

import com.example.newsfeed.data.NewsFeedApiService
import com.example.newsfeed.data.network.datasource.FeedDataSource
import com.example.newsfeed.data.network.datasource.FeedDataSourceImpl
import com.example.newsfeed.data.network.interceptor.ConnectivityInterceptor
import com.example.newsfeed.data.network.interceptor.ConnectivityInterceptorImpl
import com.example.newsfeed.data.repository.TopStoryRepository
import com.example.newsfeed.data.repository.TopStoryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindTopStoryRepository(impl: TopStoryRepositoryImpl): TopStoryRepository

    @Binds
    @Singleton
    abstract fun bindFeedDataSource(impl: FeedDataSourceImpl): FeedDataSource

    @Binds
    @Singleton
    abstract fun bindConnectionModule(impl: ConnectivityInterceptorImpl): ConnectivityInterceptor
}

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(connectivityInterceptor: ConnectivityInterceptor): NewsFeedApiService {
        return NewsFeedApiService.invoke(connectivityInterceptor)
    }
}