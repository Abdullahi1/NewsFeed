package com.example.newsfeed.di

import com.example.newsfeed.ui.fragments.feedsection.business.BusinessFragment
import com.example.newsfeed.ui.fragments.feedsection.entertainment.EntertainmentFragment
import com.example.newsfeed.ui.fragments.feedsection.science.ScienceStoryFragment
import com.example.newsfeed.ui.fragments.feedsection.sports.SportsFragment
import com.example.newsfeed.ui.fragments.feedsection.topStory.TopStoryFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, FeedDataSourceModule::class,FeedApiServiceModule::class,
    DatabaseModule::class,DatabaseDaoModule::class,ConnectionInterceptorModule::class])
interface AppComponent {
    //fun inject(fragment: ScopedFragment)

    fun inject(fragment: BusinessFragment)
    fun inject(fragment: EntertainmentFragment)
    fun inject(fragment: ScienceStoryFragment)
    fun inject(fragment: SportsFragment)
    fun inject(fragment: TopStoryFragment)


//    fun topStoryRepo() : TopStoryRepository
//
//    fun newsFeedDao() : TopStoryDao
//
//    fun newsFeedDb() : NewsFeedDatabase
//
//    fun newsFeedDataSource() : FeedDataSource
//
//    fun apiService() : NewsFeedApiService
//
//    fun connectionInterceptor() : ConnectivityInterceptor
}