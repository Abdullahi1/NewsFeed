package com.example.abdullahi.newsfeed.data.repository

import androidx.lifecycle.LiveData
import com.example.abdullahi.newsfeed.data.dao.TopStoryDao
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSource
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopStoryRepositoryImpl(
    private val topStoryDao: TopStoryDao,
    private val feedDataSource: FeedDataSource
) : TopStoryRepository {

    init {
        feedDataSource.apply {
            downloadTopFeed.observeForever { topStoryResponse ->
                persistFetchedStory(topStoryResponse)
            }
        }
    }

    private fun persistFetchedStory(topStoryResponse: TopStoryResponse?) {
        GlobalScope.launch (Dispatchers.IO){
            val newFeedId = getId(topStoryResponse!!.section)
            topStoryResponse.id = newFeedId
            topStoryDao.insert(topStoryResponse)
        }
    }

    override suspend fun getCategoryTopStory(sectionName: String) : LiveData<out TopStoryResponse>{
        return withContext(Dispatchers.IO){
            initFetchedStory(sectionName)
            val feedId = getId(sectionName)
            return@withContext topStoryDao.getSectionFeed(feedId)
        }
    }

    private suspend fun initFetchedStory(sectionName: String){
        fetchTopStory(sectionName)
    }

    private suspend fun fetchTopStory(sectionName: String){
        feedDataSource.fetchTopFeed(sectionName)
    }

    private fun getId(sectionName: String): Int{
        return when (sectionName) {
            "home" -> {
                 1
            }

            "business" -> {
                 2
            }

            "entertainment" -> {
                 3
            }

            "sports" -> {
                 4
            }

            "science" -> {
                 5
            }
            else ->  0
        }
    }
}