package com.example.abdullahi.newsfeed.data.network.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abdullahi.newsfeed.data.NewsFeedApiService
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import com.example.abdullahi.newsfeed.internal.NoConnectivityException
import timber.log.Timber

class FeedDataSourceImpl(
    private val newsFeedApiService : NewsFeedApiService
) : FeedDataSource {

    private val _downloadTopFeed = MutableLiveData<TopStoryResponse>()

    override val downloadTopFeed: LiveData<TopStoryResponse>
        get() = _downloadTopFeed

    override suspend fun fetchTopFeed(sectionName: String) {
        try {

            val categoryTopStory = newsFeedApiService.getCategoryTopStory(sectionName).await()
            _downloadTopFeed.postValue(categoryTopStory)

        }catch (e : NoConnectivityException ){
            Timber.e(e, "No internet connection.")

        }

    }
}