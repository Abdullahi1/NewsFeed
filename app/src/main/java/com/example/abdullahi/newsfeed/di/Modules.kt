package com.example.abdullahi.newsfeed.di

import android.content.Context
import com.example.abdullahi.newsfeed.data.NewsFeedApiService
import com.example.abdullahi.newsfeed.data.dao.NewsFeedDatabase
import com.example.abdullahi.newsfeed.data.dao.TopStoryDao
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSource
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSourceImpl
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptor
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptorImpl
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepository
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module(includes = [DatabaseDaoModule::class, FeedDataSourceModule::class])
class RepositoryModule{
    @Provides
    @Singleton
    fun providesTopStoryRepository(dao: TopStoryDao, dataSource: FeedDataSource) : TopStoryRepository =
        TopStoryRepositoryImpl(dao,dataSource)
}

@Module(includes = [DatabaseModule::class])
class DatabaseDaoModule{
    @Provides
    @Singleton
    fun providesNewsFeedDao(newsFeedDatabase: NewsFeedDatabase) : TopStoryDao = newsFeedDatabase.topStoryDao()
}

@Module(includes = [ContextModule::class])
class DatabaseModule{
    @Provides
    @Singleton
    fun providesDatabase(context: Context) :NewsFeedDatabase = NewsFeedDatabase(context)
}

@Module(includes = [FeedApiServiceModule::class])
class FeedDataSourceModule{
    @Provides
    @Singleton
    fun providesFeedDataSource(apiService: NewsFeedApiService) : FeedDataSource = FeedDataSourceImpl(apiService)
}

@Module(includes = [ConnectionInterceptorModule::class])
class FeedApiServiceModule{
    @Provides
    @Singleton
    fun providesFeedApiService(connectivityInterceptor: ConnectivityInterceptor) : NewsFeedApiService
            = NewsFeedApiService.invoke(connectivityInterceptor)
}

@Module(includes = [ContextModule::class])
class ConnectionInterceptorModule{

    @Provides
    @Singleton
    fun providesConnectionInterceptor(context: Context): ConnectivityInterceptor = ConnectivityInterceptorImpl(context)
}

@Module
class ContextModule(val context : Context){
    @Provides
    fun providesContext() : Context = context
 }