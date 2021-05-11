package com.example.newsfeed.data.network.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsfeed.data.NewsFeedApiService
import com.example.newsfeed.data.network.response.TopStoryResponse
import com.example.newsfeed.internal.NoConnectivityException
import timber.log.Timber
import javax.inject.Inject

class FeedDataSourceImpl @Inject constructor(
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