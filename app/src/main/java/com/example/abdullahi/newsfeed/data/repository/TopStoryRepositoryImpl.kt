package com.example.abdullahi.newsfeed.data.repository

import androidx.lifecycle.LiveData
import com.example.abdullahi.newsfeed.data.dao.TopStoryDao
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSource
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import com.example.abdullahi.newsfeed.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup



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
            //insertContent(topStoryResponse!!.results)
            topStoryDao.insert(topStoryResponse)
        }
    }

    private fun insertContent(results: List<Result>) {
        results.forEach {
            val doc = Jsoup.connect(it.url).get()
            val newsContent = doc.body().text()
            it.content = newsContent
        }
    }

    override suspend fun getCategoryTopStory(sectionName: String) : LiveData<out TopStoryResponse>{
        return withContext(Dispatchers.IO){
            initFetchedStory(sectionName)
            var name = sectionName.substring(0,1).toUpperCase() + sectionName.substring(1)
            if(sectionName == "home"){
                name = "home"
            }
            val feedId = getId(name)
            return@withContext topStoryDao.getSectionFeed(feedId)
        }
    }

    private fun capitalize(str : String) : String{
        if (str == null || str.isEmpty()) return str

        return str.substring(0,1).toUpperCase() + str.substring(1)
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

            "Business" -> {
                 2
            }

            "Movies" -> {
                 3
            }

            "Sports" -> {
                 4
            }

            "Science" -> {
                 5
            }
            else ->  0
        }
    }
}